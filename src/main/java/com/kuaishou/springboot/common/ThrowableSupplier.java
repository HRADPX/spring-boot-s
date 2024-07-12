package com.kuaishou.springboot.common;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-19
 */
public interface ThrowableSupplier<T, X extends Throwable> {

    T get() throws X;

    static <T, X extends Throwable> ThrowableSupplier<T, X> cast(ThrowableSupplier<T, X> func) {
        return func;
    }
}

