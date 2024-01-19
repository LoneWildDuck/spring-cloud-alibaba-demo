package org.xujiaqi.service;

import org.springframework.stereotype.Service;
import org.xujiaqi.model.CommonOut;

@Service
public class TestOpenFeignServiceImpl implements TestOpenFeignService{

    @Override
    public CommonOut testOpenFeign() {
        CommonOut out = new CommonOut();
        out.setRespCode("200");
        return out;
    }
}
