package org.xujiaqi.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.xujiaqi.entity.MeetingRoomXjq;
import org.xujiaqi.mapper.MeetingRoomXjqMapper;
import org.xujiaqi.model.AddMeetingIn;
import org.xujiaqi.model.CommonOut;

@DubboService
public class TestDubboServiceImpl implements TestDubboService {

    @Autowired(required = true)
    MeetingRoomXjqMapper meetingRoomXjqMapper;

    public CommonOut get(AddMeetingIn meetingIn){
        MeetingRoomXjq meetingRoomXjq = getMeetingRoom(meetingIn.getRoomNo(), meetingIn.getRoomSize());
        meetingRoomXjqMapper.insertSelective(meetingRoomXjq);
        String a = JSONObject.toJSONString(meetingRoomXjq);
        CommonOut out = new CommonOut();
        out.setRespCode("200");
        out.setRespDesc(a);
        return out;
    }

    private MeetingRoomXjq getMeetingRoom(String reemNo,Integer roomSize){
        MeetingRoomXjq roomXjq = new MeetingRoomXjq();
        roomXjq.setRoomNo(reemNo);
        roomXjq.setRoomSize(roomSize);
        return roomXjq;
    }
}
