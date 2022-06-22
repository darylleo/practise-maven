package com.daryl.pojo;

import java.io.Serializable;

/**
 * @author wl
 * @create 2022-01-04
 */
public class User implements Serializable {

    private Integer id;

    private String name;

    private String gender;

    private String remark;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
