package com.neusoft.mpserver.domain;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户domain对象
 * @Data：注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
 * @Setter：注解在属性上；为属性提供 setting 方法
 * @Getter：注解在属性上；为属性提供 getting 方法
 * @NoArgsConstructor：注解在类上；为类提供一个无参的构造方法
 * @AllArgsConstructor：注解在类上；为类提供一个全参的构造方法
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
