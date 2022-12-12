package org.gavincui.imutest.biz;

import java.util.List;

import org.gavincui.imutest.dao.PositionDao;
import org.gavincui.imutest.dao.model.Position;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags = "工位管理")
@RestController
@RequestMapping(value = "/imu/position")
public class PositionController extends AbstractBaseController<PositionDao, Position> {

    @GetMapping("/{lineId}")
    List<Position> getByLine(@PathVariable String lineId) {
        return dao.queryByLineId(lineId);
    }
}
