package org.gavincui.imutest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

@RestController
@RequestMapping
public class ImuController {
    Logger log = LoggerFactory.getLogger(ImuController.class);

    private static final LinkedList<Double> xData = new LinkedList<>();
    private static final List<Double> xData2 = new ArrayList<>();
    private static final List<Integer> zeroList = new ArrayList<>();

    private double thresholdX = 0.3;

    private int zeroAccount = 3;

    @GetMapping(value = "/imu/hello")
    public String hello() {
        log.debug("hello ...");
        for (Session session : WSController.socketList) {
            session.getAsyncRemote().sendText("hello ...");
        }
        return "imu display system  v1.0, zero.thresholdX = " + thresholdX;
    }

    @GetMapping(value = "/imu/params")
    public String getParam() {
        HashMap<String, Number> params = new HashMap<>();
        params.put("thresholdX", thresholdX);
        params.put("zeroAccount", zeroAccount);

        return JSON.toJSONString(params);
    }

    @PutMapping(value = "/imu/params")
    public ResponseEntity<HttpStatus> putParam(@RequestBody String body) {
        JSONObject data = JSON.parseObject(body);

        thresholdX = data.getDoubleValue("thresholdX");
        zeroAccount = data.getIntValue("zeroAccount");

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/imu/update")
    public ResponseEntity<HttpStatus> putValue(@RequestBody String body) {
        // log.debug(body);

        JSONObject data = JSON.parseObject(body);
        JSONArray datas = data.getJSONArray("value");

        double newData = datas.getDoubleValue(0);

        HashMap<String, Number> v = new HashMap<>();
        v.put("value", newData);
        for (Session session : WSControllerOrigin.socketList) {
            if (session != null && session.isOpen()) {
                session.getAsyncRemote().sendText(JSON.toJSONString(v));
            }
        }
        if (Math.abs(newData) - thresholdX < 0) {
            newData = 0;
        }

        // log.debug("newData = " + newData);

        xData.add(newData);
        if (xData.size() == 100) {
            xData.clear();
        }

        if (newData == 0) {
            zeroList.add(0);
        } else {
            zeroList.clear();
        }

        if (zeroList.size() > 0 && zeroList.size() >= zeroAccount) {
            if (xData2.size() > 10) {
                log.debug("xData2:" + xData2);
                calculateCycle(xData2);
            }
        } else {
            xData2.add(newData);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    private void calculateCycle(List<Double> xdata22) {

        if (xdata22.stream().mapToDouble(v -> v).sum() == 0) {
            return;
        }

        int pt = 0;
        int nt = 0;
        int st = 0;

        for (Double value : xdata22) {
            if (value > 0) {
                pt += 1;
            }
        }

        for (Double value : xdata22) {
            if (value < 0) {
                nt += 1;
            }
        }
        for (Double value : xdata22) {
            if (value == 0) {
                st += 1;
            }
        }

        xdata22.clear();

        JSONObject rs = new JSONObject();
        rs.put("value", new double[] { pt, nt, st });

        log.debug(JSON.toJSONString(rs) + ",thresholdX:" + thresholdX + ",zeroAccount:" + zeroAccount);

        for (Session session : WSController.socketList) {
            if (session != null && session.isOpen()) {
                session.getAsyncRemote().sendText(JSON.toJSONString(rs));
            }
        }
    }

}
