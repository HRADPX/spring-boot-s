package com.kuaishou.springboot.autoproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-10-13
 */
public class ProxyInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("interceptor run....");
        return invocation.proceed();
    }
}
