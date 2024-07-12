package com.kuaishou.springboot.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-01-04
 */
@Slf4j
public class EnhancerInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("arguments: {}, method: {}", objects, method);
//        return method.invoke(o, objects);
        return methodProxy.invokeSuper(o, objects); // 执行父类方法
    }
}
