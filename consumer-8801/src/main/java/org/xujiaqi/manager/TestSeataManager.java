package org.xujiaqi.manager;

import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xujiaqi.entity.MeetingRoomXjq;
import org.xujiaqi.mapper.MeetingRoomXjqMapper;
import org.xujiaqi.model.AddMeetingIn;
import org.xujiaqi.service.TestDubboService;

@Service
public class TestSeataManager {

    @DubboReference
    TestDubboService testDubboService;
    @Autowired
    MeetingRoomXjqMapper meetingRoomXjqMapper;

    @GlobalTransactional(name = "test")
    public void addMeeting(AddMeetingIn in){
        testDubboService.get(in);
        MeetingRoomXjq roomXjq = getMeetingRoom(in.getRoomNo(), in.getRoomSize());
        meetingRoomXjqMapper.insertSelective(roomXjq);
        throw new RuntimeException("测试回滚");
    }

    private MeetingRoomXjq getMeetingRoom(String reemNo,Integer roomSize){
        MeetingRoomXjq roomXjq = new MeetingRoomXjq();
        roomXjq.setRoomNo(reemNo);
        roomXjq.setRoomSize(roomSize);
        return roomXjq;
    }
}
