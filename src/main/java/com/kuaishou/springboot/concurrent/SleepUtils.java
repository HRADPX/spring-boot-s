package com.kuaishou.springboot.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-26
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " ---- " + e.getMessage());
        }
    }
}
