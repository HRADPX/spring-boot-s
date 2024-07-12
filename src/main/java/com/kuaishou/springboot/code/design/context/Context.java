package com.kuaishou.springboot.code.design.context;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-06-01
 */
public class Context {

    private String name;
    private String id;

    public String print() {
        return "name: " + name + ", id: " + id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
