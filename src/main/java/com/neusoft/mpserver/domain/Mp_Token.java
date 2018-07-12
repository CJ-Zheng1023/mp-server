package com.neusoft.mpserver.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * token映射实体类
 * @name fandp
 * @email fandp@neusoft.com
 */
@Data
@Entity
public class Mp_Token {
    //id
    @Id
    private String id;
    //userid
    private String user_id;
    //last_time
    private String last_time;


}
