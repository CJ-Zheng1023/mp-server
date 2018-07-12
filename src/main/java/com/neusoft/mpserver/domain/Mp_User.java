package com.neusoft.mpserver.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户domain对象
 */
@Data
@Entity
public class Mp_User {
    //id
    @Id
    private String  id;
    //username
    private  String username;
    //password
    private String password;
    //createTime
    private String createTime;
}
