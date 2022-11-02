package org.gavincui.imutest.biz;

import org.gavincui.imutest.dao.Position;
import org.gavincui.imutest.dao.PositionDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags = "工位管理")
@RestController
@RequestMapping(value = "/imu/position")
public class PositionController extends AbstractBaseController<PositionDao, Position> {
}
