package com.kuaishou.springboot.autoproxy;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-10-13
 */
public class ProxyService implements ProxyInterface {
    @Override
    public void execute(String s) {
        System.out.println(s.toLowerCase() + "_" + s.toUpperCase());
    }
}
