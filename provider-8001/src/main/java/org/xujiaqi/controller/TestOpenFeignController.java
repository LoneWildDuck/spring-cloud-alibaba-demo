package org.xujiaqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xujiaqi.model.CommonOut;
import org.xujiaqi.service.TestOpenFeignService;

@RestController
public class TestOpenFeignController {
    @Autowired
    TestOpenFeignService testOpenFeignService;

    @GetMapping("/testOpenFeign")
    public CommonOut testOpenFeign() {
        return testOpenFeignService.testOpenFeign();
    }
}
