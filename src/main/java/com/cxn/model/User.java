package com.cxn.model;

import java.io.Serializable;

/**
 * @program: mybatis
 * @description: ${description}
 * @author: cxn
 * @create: 2018-04-19 13:25
 * @Version v1.0
 */
public class User implements Serializable{
    private static final long serialVersionUID = -8071928573136573737L;
    private String name;
    private String address;
    private Integer id;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
