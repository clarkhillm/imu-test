package org.gavincui.imutest.biz;

import org.gavincui.imutest.dao.LineDao;
import org.gavincui.imutest.dao.model.Line;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags = "生产线管理")
@RestController
@RequestMapping(value = "/imu/line")
public class LineController extends AbstractBaseController<LineDao, Line> {

}
