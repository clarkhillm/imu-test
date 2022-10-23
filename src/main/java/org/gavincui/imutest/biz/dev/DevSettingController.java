package org.gavincui.imutest.biz.dev;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.gavincui.imutest.biz.AbstractBaseController;
import org.gavincui.imutest.dao.dev.setting.DevSetting;
import org.gavincui.imutest.dao.dev.setting.DevSettingDao;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags = "设备管理")
@RestController
@RequestMapping(value = "/imu/dev")
public class DevSettingController extends AbstractBaseController<DevSettingDao, DevSetting> {

}
