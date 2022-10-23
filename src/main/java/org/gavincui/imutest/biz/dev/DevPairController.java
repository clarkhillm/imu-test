package org.gavincui.imutest.biz.dev;

import org.gavincui.imutest.biz.AbstractBaseController;
import org.gavincui.imutest.dao.dev.pair.DevPair;
import org.gavincui.imutest.dao.dev.pair.DevPairDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags = "设备组管理")
@RestController
@RequestMapping(value = "/imu/dev/pair")
public class DevPairController extends AbstractBaseController<DevPairDao, DevPair> {

}
