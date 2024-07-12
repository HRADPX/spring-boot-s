package com.kuaishou.springboot.test;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-26
 */
public class StaticClass {

    public static int field = 2;

    public StaticClass() {
        System.out.println("init ....");
    }

    public static int getField() {
        return field;
    }

    public static void setField(int newFiled) {
        field = newFiled;
    }
}
