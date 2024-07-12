package com.kuaishou.springboot.code.utils;

import java.lang.reflect.Constructor;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-24
 */
public abstract class ReflectUtils {

    private ReflectUtils() {
    }

    public static <T> T getInstance(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
