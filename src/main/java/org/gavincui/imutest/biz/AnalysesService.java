package org.gavincui.imutest.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.gavincui.imutest.dao.DevSettingDao;
import org.gavincui.imutest.dao.PositionDao;
import org.gavincui.imutest.dao.model.DevSetting;
import org.gavincui.imutest.dao.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.QueryApi;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;

@Service
public class AnalysesService {

    Logger log = LoggerFactory.getLogger(AnalysesService.class);

    @Value("${influx.url}")
    private String url;

    @Value("${influx.token}")
    private String token;

    @Value("${influx.org}")
    private String org;

    @Resource
    private PositionDao positionDao;

    @Resource
    private DevSettingDao devSettingDao;

    public HashMap<String, List<DataItem>> query(String positionId, String dateRange) {
        HashMap<String, List<DataItem>> rs = new HashMap<>();
        Position position = positionDao.findById(positionId).orElse(null);

        InfluxDBClient client = InfluxDBClientFactory.create(url, token.toCharArray(), org);

        if (position != null) {
            rs.put("cycle", queryCycle(positionId, dateRange));
            List<DevSetting> devList = devSettingDao.queryByPositionId(positionId);
            for (DevSetting devSetting : devList) {
                String flux = "from(bucket: \"" + position.getCode() + "\")"
                        + "|> range(" + dateRange + ")"
                        + "|> filter(fn: (r) => r[\"_measurement\"] == \"" + devSetting.getMeasurement() + "\")"
                        + "|> filter(fn: (r) => r[\"_field\"] == \"value\")"
                        + "|> yield()";

                // log.debug("flux:" + flux);

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

    public List<DataItem> queryCycle(String positionId, String dateRange) {
        List<DataItem> rs = new ArrayList<>();
        Position position = positionDao.findById(positionId).orElse(null);
        InfluxDBClient client = InfluxDBClientFactory.create(url, token.toCharArray(), org);
        if (position != null) {
            String flux = "from(bucket: \"" + position.getCode() + "\")"
                    + "|> range(" + dateRange + ")"
                    + "|> filter(fn: (r) => r[\"_measurement\"] == \"cycle\")"
                    + "|> filter(fn: (r) => r[\"_field\"] == \"value\")"
                    + "|> yield()";

            QueryApi queryApi = client.getQueryApi();
            List<FluxTable> tables = queryApi.query(flux);
            for (FluxTable fluxTable : tables) {
                List<FluxRecord> records = fluxTable.getRecords();
                for (FluxRecord fluxRecord : records) {
                    DataItem item = new DataItem();
                    item.setDatetime(new Date(fluxRecord.getTime().toEpochMilli()));
                    item.setDevId("cycle-sensor");
                    item.setValue(Double.parseDouble(fluxRecord.getValueByKey("_value").toString()));
                    rs.add(item);
                }
            }
        }
        client.close();

        return rs;
    }
}
