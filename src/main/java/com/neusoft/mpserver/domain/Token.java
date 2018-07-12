package com.neusoft.mpserver.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * token映射实体类
 * @name fandp
 * @email fandp@neusoft.com
 */
@Data
@Entity
@Table(name="MP_TOKEN")
public class Token {
    //id
    @Id
    private String tokenId;
    //userid
    private String userId;
    //last_time
    private String lastTime;


}
