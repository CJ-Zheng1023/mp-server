package com.neusoft.mpserver.domain;

import lombok.Data;

@Data
public class Patent {
    //an 案卷号
    private String an;
    //ti 标题
    private String ti;
    //in 发明人
    private String in;
    //paas 申请人
    private String paas;
    //国省代码
    private String location;

}
