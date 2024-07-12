package com.kuaishou.springboot.properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-04-27
 */
@Component
public class ConfigTreeProperties {

    @Autowired
    private Environment environment;

    @PostConstruct
    public void init() {
        System.out.println(environment.getProperty("name"));
        System.out.println(environment.getProperty("username"));
        System.out.println(environment.getProperty("my.name"));
    }

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
