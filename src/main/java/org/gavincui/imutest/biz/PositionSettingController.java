package org.gavincui.imutest.biz;

import java.util.UUID;

import javax.annotation.Resource;

import org.gavincui.imutest.dao.PositionSetting;
import org.gavincui.imutest.dao.PositionSettingDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        String settings = settingDao.getSettings(id);
        return JSONObject.parse(settings);
    }

    @PostMapping
    void create(@RequestBody PositionSetting setting) {
        setting.setId(UUID.randomUUID().toString());
        settingDao.save(setting);
    }

    @PutMapping
    void update(@RequestBody PositionSetting setting) {
        settingDao.save(setting);
    }
}
