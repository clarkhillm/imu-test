package org.gavincui.imutest.biz;

import java.util.UUID;

import javax.annotation.Resource;

import org.gavincui.imutest.dao.PositionSettingDao;
import org.gavincui.imutest.dao.model.PositionSetting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;

@Api(tags = "工位分析配置")
@RestController
@RequestMapping(value = "/imu/position/setting")
public class PositionSettingController {
    @Resource
    PositionSettingDao settingDao;

    @GetMapping(value = "/{id}")
    Object getSettings(@PathVariable String id) {
        PositionSetting settings = settingDao.getSettings(id);
        if (settings == null || settings.equals("")) {
            return new JSONObject();
        } else {
            return settings;
        }
    }

    @PutMapping
    void update(@RequestBody PositionSetting setting) {
        if (setting.getId().equals("")) {
            setting.setId(UUID.randomUUID().toString());
        }
        settingDao.save(setting);
    }
}
