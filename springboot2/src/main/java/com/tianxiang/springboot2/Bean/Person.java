package com.tianxiang.springboot2.Bean;

import com.sun.javafx.collections.MappingChange;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component //生成当前累的实例对象  存到Ioc容器中。
@ConfigurationProperties(prefix = "person")//将配置文件中前缀为person属性的值映射到当前类的变量上。
public class Person {
    private int id;
    private String name;
    private List hobby;
    private String[] famliyNumbers;
    private Map<String,String> map;
    private Pet pet;



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobby=" + hobby +
                ", famliyNumbers=" + Arrays.toString(famliyNumbers) +
                ", map=" + map +
                ", pet=" + pet +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getHobby() {
        return hobby;
    }

    public void setHobby(List hobby) {
        this.hobby = hobby;
    }

    public String[] getFamliyNumbers() {
        return famliyNumbers;
    }

    public void setFamliyNumbers(String[] famliyNumbers) {
        this.famliyNumbers = famliyNumbers;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
