package com.itheima.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/9/10
 * @description 标题
 * @package com.itheima.pojo
 */
//Table设置映射表 ，name指定表名
@Table(name = "tb_user")
@Entity//实体对象 需要和数据库建立映射关系 标识
public class User {
    //@id 标识该字段对应的是表中的主键
    @Id
    //  @GeneratedValue设置主键的生成策略
    // strategy 指定策略类型： GenerationType.IDENTITY 标识自增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//主键id

    //@Column将POJO的属性 映射给数据表的某一个列  name用于指定列的名称，如果是列名和属性名一致可以不写。
    @Column
    private String username;//用户名
    @Column
    private String password;//密码
    @Column
    private String name;//姓名
    @Column
    private Integer age;//年龄
    @Column
    private Integer sex;//性别 1男性，2女性
    @Column
    private Date birthday; //出生日期
    @Column
    private Date created; //创建时间
    @Column
    private Date updated; //更新时间
    @Column
    private String note;//备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
