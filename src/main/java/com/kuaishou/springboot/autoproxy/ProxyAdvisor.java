package com.kuaishou.springboot.autoproxy;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-10-13
 */
public class ProxyAdvisor implements Advisor {
    @Override
    public Advice getAdvice() {
        return (MethodBeforeAdvice) (m, args, target) ->
                System.out.println("method: " + m.getName() + ", before advice run....");
    }

    @Override
    public boolean isPerInstance() {
        return true;
    }
}
