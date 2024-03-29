package org.xujiaqi.controller;

//import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.xujiaqi.entity.MeetingRoomXjq;
import org.xujiaqi.manager.TestSeataManager;
import org.xujiaqi.manager.TestSentinelResourceManager;
import org.xujiaqi.model.AddMeetingIn;
import org.xujiaqi.service.TestDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xujiaqi.model.CommonOut;
import org.xujiaqi.service.TestOpenFeignConsumerService;
import org.xujiaqi.service.TestSentinelService;

@RestController
@RefreshScope
public class TestConsumerController {

    @Value(value = "${env}")
    private String env;

    @Autowired
    TestOpenFeignConsumerService testOpenFeignConsumerService;
    @Autowired
    RestTemplate restTemplate;
    @DubboReference
    TestDubboService testDubboService;
    @Reference
    TestSentinelService testSentinelService;
    @Autowired
    TestSentinelResourceManager testSentinelResourceManager;
    @Autowired
    TestSeataManager testSeataManager;

    @GetMapping("testOpenFeign")
    public CommonOut testOpenFeign(){
        return testOpenFeignConsumerService.testOpenFeign();
    }

    @GetMapping("testOpenFeign2")
    public CommonOut testOpenFeign2(){
        return restTemplate.getForObject("http://spring-cloud-alibaba-provider/testOpenFeign",CommonOut.class);
    }

    @GetMapping("testDubbo")
    public CommonOut tesDubbo(String roomNo, Integer roomSize){
        AddMeetingIn in = new AddMeetingIn();
        in.setRoomNo(roomNo);
        in.setRoomSize(roomSize);
        testSeataManager.addMeeting(in);
        CommonOut out = new CommonOut();
        out.setRespCode("200");
        return out;
    }

    //测试获取nacos的配置
    @GetMapping("testNacosConfig")
    public CommonOut testNacosConfig(){
        CommonOut out = new CommonOut();
        out.setRespCode(env);
        return out;
    }

    //测试Sentinel
    @GetMapping("testSentinel")
    public CommonOut  testSentinel(){
        return testSentinelService.testSentinel();
    }


    @GetMapping("testSentinelResource")
    public String testSentinelResource(){
        return testSentinelResourceManager.test();
    }





}
