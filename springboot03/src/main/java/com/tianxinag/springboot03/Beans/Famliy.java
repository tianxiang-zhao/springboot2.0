package com.tianxinag.springboot03.Beans;

import org.springframework.data.redis.core.index.Indexed;

public class Famliy {

    @Indexed
    private  String type;
    @Indexed
    private String username;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Famliy{" +
                "type='" + type + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
