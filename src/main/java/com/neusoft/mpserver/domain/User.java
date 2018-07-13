package com.neusoft.mpserver.domain;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @Entity注释指名这是一个实体Bean，@Table注释指定了Entity所要映射带数据库表，其中@Table.name()用来指定映射表的表名。
如果缺省@Table注释，系统默认采用类名作为映射表的表名。实体Bean的每个实例代表数据表中的一行数据，行中的一列对应实例中的一个属性。
 @Column注释定义了将成员属性映射到关系表中的哪一列和该列的结构信息，属性如下：
 1）name：映射的列名。如：映射tbl_user表的name列，可以在name属性的上面或getName方法上面加入；
 2）unique：是否唯一；
 3）nullable：是否允许为空；
 4）length：对于字符型列，length属性指定列的最大字符长度；
 5）insertable：是否允许插入；
 6）updatetable：是否允许更新；
 7）columnDefinition：定义建表时创建此列的DDL；
 8）secondaryTable：从表名。如果此列不建在主表上（默认是主表），该属性定义该列所在从表的名字。
 @Id注释指定表的主键，它可以有多种生成方式：
 1）TABLE：容器指定用底层的数据表确保唯一；
 2）SEQUENCE：使用数据库德SEQUENCE列莱保证唯一（Oracle数据库通过序列来生成唯一ID）；
 3）IDENTITY：使用数据库的IDENTITY列莱保证唯一；
 4）AUTO：由容器挑选一个合适的方式来保证唯一；
 5）NONE：容器不负责主键的生成，由程序来完成。
 @GeneratedValue注释定义了标识字段生成方式。
 @Temporal注释用来指定java.util.Date或java.util.Calender属性与数据库类型date、time或timestamp中的那一种类型进行映射。
 @Temporal(value=TemporalType.TIME)

 映射规则：
 1. 实体类必须用 @javax.persistence.Entity 进行注解；
 2. 必须使用 @javax.persistence.Id 来注解一个主键；
 3. 实体类必须拥有一个 public 或者 protected 的无参构造函数，之外实体类还可以拥有其他的构造函数；
 4. 实体类必须是一个顶级类（top-level class）。一个枚举（enum）或者一个接口（interface）不能被注解为一个实体；
 5. 实体类不能是 final 类型的，也不能有 final 类型的方法；
 */

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
