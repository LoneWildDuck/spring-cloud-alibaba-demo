package org.xujiaqi.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddMeetingIn implements Serializable {
    private static final long serialVersionUID = 1576477607831612799L;

    private String roomNo;

    private Integer roomSize;
}
