package com.tianxiang.springboot6.Dao;



import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

@Repository
@Entity(name = "tbl_employee")//对应的数据表
public class Person implements Serializable { //Serializable只有实现序列化才能存入redis中。
    @Id//表明映射对应的主键id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置主键自增
    private Integer id;
    private String last_name;
    private String gender;
    private String email;
    @Column(name = "d_id")//指定映射表字段名 当变量名与数据库字段名不一致时
    private Integer dId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}
