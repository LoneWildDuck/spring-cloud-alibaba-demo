package org.xujiaqi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.cloud.nacos.config.namespace}")
    private String env;
    @Value("${appId}")
    private String appId;

    @GetMapping("get")
    public String get(){
        log.info(appId);
        return env+"|"+url;
    }
}
