package org.xujiaqi.service;

import org.xujiaqi.model.AddMeetingIn;
import org.xujiaqi.model.CommonOut;

public interface TestDubboService {
    CommonOut get(AddMeetingIn meetingIn);
}
