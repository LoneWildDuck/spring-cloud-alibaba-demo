package org.xujiaqi.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonOut implements Serializable {
    private static final long serialVersionUID = -8112133690874000829L;
    private String respCode;
    private String respDesc;
}
