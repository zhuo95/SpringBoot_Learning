package com.zz.initializrstart.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * User 实体
 */

@XmlRootElement // mediatype 转为xml
public class User {

    private Long id;//唯一标识
    private String name;
    private Integer age;

    public User(){
    }

    public User(Long id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setAge(int age) {
        this.age = age;
    }
}
