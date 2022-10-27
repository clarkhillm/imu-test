package org.gavincui.imutest.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.gavincui.imutest.dao.DevSetting;
import org.gavincui.imutest.dao.DevSettingDao;
import org.gavincui.imutest.dao.Position;
import org.gavincui.imutest.dao.PositionDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.QueryApi;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;

@Service
public class AnalysesService {

    @Value("${influx.url}")
    private String url;

    @Value("${influx.token}")
    private String token;

    @Value("${influx.org}")
    private String org;

    @Value("${influx.bucket}")
    private String bucket;

    @Resource
    private PositionDao positionDao;

    @Resource
    private DevSettingDao devSettingDao;

    public HashMap<String, List<DataItem>> query(String positionId, String timeDesc) {
        HashMap<String, List<DataItem>> rs = new HashMap<>();
        Position position = positionDao.findById(positionId).orElse(null);

        InfluxDBClient client = InfluxDBClientFactory.create(url, token.toCharArray(), org);
        if (position != null) {
            List<DevSetting> devList = devSettingDao.queryByPositionId(positionId);
            for (DevSetting devSetting : devList) {
                String flux = "from(bucket: \"" + bucket + "\")"
                        + "|> range(start: " + timeDesc + ")"
                        + "|> filter(fn: (r) => r[\"_measurement\"] == \"" + devSetting.getMeasurement() + "\")"
                        + "|> filter(fn: (r) => r[\"_field\"] == \"value\")"
                        + "|> filter(fn: (r) => r[\"sensor_id\"] == \"" + devSetting.getDevId() + "\")"
                        + "|> yield()";

                List<DataItem> dataItems = new ArrayList<>();
                rs.put(devSetting.getWrist(), dataItems);
                QueryApi queryApi = client.getQueryApi();
                List<FluxTable> tables = queryApi.query(flux);
                for (FluxTable fluxTable : tables) {
                    List<FluxRecord> records = fluxTable.getRecords();
                    for (FluxRecord fluxRecord : records) {
                        DataItem item = new DataItem();
                        item.setDatetime(new Date(fluxRecord.getTime().toEpochMilli()));
                        item.setDevId(devSetting.getDevId());
                        item.setValue(Double.parseDouble(fluxRecord.getValueByKey("_value").toString()));
                        dataItems.add(item);
                    }
                }
            }
        }
        client.close();

        return rs;
    }

}
