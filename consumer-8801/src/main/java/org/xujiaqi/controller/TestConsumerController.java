package org.xujiaqi.controller;

//import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
//import org.xujiaqi.model.CommonOut;
import org.xujiaqi.service.TestDubboService;
//import org.xujiaqi.service.TestOpenFeignConsumerService;
//import org.xujiaqi.service.TestSentinelService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xujiaqi.model.CommonOut;

import javax.annotation.Resource;

@RestController
@RefreshScope
public class TestConsumerController {

//    @Value(value = "${env}")
//    private String env;

//    @Resource
//    TestOpenFeignConsumerService testOpenFeignService;
    @Autowired
    RestTemplate restTemplate;

//    @Reference
//    TestSentinelService testSentinelService;

    @Reference
    TestDubboService testDubboService;

//    @GetMapping("testOpenFeign")
//    public CommonOut testOpenFeign(){
//        return testOpenFeignService.testOpenFeign();
//    }

    @GetMapping("testOpenFeign2")
    public CommonOut testOpenFeign2(){
        return restTemplate.getForObject("http://spring-cloud-alibaba-provider/testOpenFeign",CommonOut.class);
    }

    @GetMapping("testDubbo")
    public CommonOut tesDubbo(){
        return testDubboService.get();
    }

//    @GetMapping("testNacosConfig")
//    public CommonOut testNacosConfig(){
//        CommonOut out = new CommonOut();
//        out.setRespCode(env);
//        return out;
//    }

//    @GetMapping("testSentinelResource")
//    public CommonOut  testSentinelResource(){
//        return testSentinelService.testSentinel();
//    }


//    @SentinelResource(value = "test")
//    public String test(){
//        return "test";
//    }



}
