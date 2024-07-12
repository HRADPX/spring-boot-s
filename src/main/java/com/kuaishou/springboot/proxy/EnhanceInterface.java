package com.kuaishou.springboot.proxy;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-01-04
 */
public interface EnhanceInterface {

    default void println() {
        System.out.println("default interface method run...");
    }
}
