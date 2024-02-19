package org.xujiaqi.manager;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestSentinelResourceManager {

    @SentinelResource(value = "test", blockHandler = "testBlockHandler")
    public String test(){
        return "test";
    }

    public String testBlockHandler(BlockException e){
        return "您好,转账服务已限流,请您稍后再试.";
    }
}
