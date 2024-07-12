package com.kuaishou.springboot.model;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-11-30
 */
public class MaterialV1 {

    public int id;

    public String desc;

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}
