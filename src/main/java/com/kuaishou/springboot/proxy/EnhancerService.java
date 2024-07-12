package com.kuaishou.springboot.proxy;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-01-04
 */
public class EnhancerService {

    public String execute(String s) {
        return "original method execute: " + s;
    }
}
