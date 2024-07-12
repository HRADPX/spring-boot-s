package com.kuaishou.springboot.code.design.util;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-06-01
 */
public class SleepUtils {

    private SleepUtils() {

    }

    public static void sleep(long periodTime) {
        if (periodTime <= 0) {
            return;
        }
        try {
            Thread.sleep(periodTime);
        } catch (Exception e) {
            // ignore
        }
    }
}
