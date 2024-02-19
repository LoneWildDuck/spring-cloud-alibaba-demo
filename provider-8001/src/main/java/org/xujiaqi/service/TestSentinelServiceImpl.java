package org.xujiaqi.service;

import org.xujiaqi.model.CommonOut;
import org.apache.dubbo.config.annotation.Service;

@Service
public class TestSentinelServiceImpl implements TestSentinelService{


    @Override
    public CommonOut testSentinel() {
        CommonOut out = new CommonOut();
        out.setRespCode("testSentinel");
        return out;
    }
}
