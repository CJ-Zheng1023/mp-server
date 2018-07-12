package com.neusoft.mpserver.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户domain对象
 * @name fandp
 * @email fandp@neusoft.com
 */
@Data
@Entity
@Table(name="MP_USER")
public class User {
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
