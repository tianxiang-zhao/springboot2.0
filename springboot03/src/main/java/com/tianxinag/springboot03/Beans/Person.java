package com.tianxinag.springboot03.Beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;

@RedisHash("persons")
public class Person {
    @Id  //用于表示实体类主键
    private  String id;
    @Indexed//表示属性会在redis中生成二级索引。
    private String firstname;
    @Indexed//表示属性会在redis中生成二级索引。
    private String lastname;

    private Address address;
    private List<Famliy> famliyList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Famliy> getFamliyList() {
        return famliyList;
    }

    public void setFamliyList(List<Famliy> famliyList) {
        this.famliyList = famliyList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address=" + address +
                ", famliyList=" + famliyList +
                '}';
    }
}
