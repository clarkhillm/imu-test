package org.gavincui.imutest.biz;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "分析管理")
@RequestMapping(value = "/imu/analyses")
public class AnalysesController {

    @Resource
    private AnalysesService service;

    @GetMapping(value = "/query/{position}")
    HashMap<String, List<DataItem>> query(@PathVariable String position) {
        HashMap<String, List<DataItem>> rs = service.query(position);
        return rs;
    }

}
