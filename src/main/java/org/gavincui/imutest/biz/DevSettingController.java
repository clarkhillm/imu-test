package org.gavincui.imutest.biz;

import org.gavincui.imutest.dao.DevSettingDao;
import org.gavincui.imutest.dao.model.DevSetting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags = "设备管理")
@RestController
@RequestMapping(value = "/imu/dev")
public class DevSettingController extends AbstractBaseController<DevSettingDao, DevSetting> {

}
