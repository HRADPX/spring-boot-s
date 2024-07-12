package com.kuaishou.springboot.circle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-19
 */
@Component
@Aspect
public class CustomAspect {

    @Before("execution(public void com.kuaishou.springboot.circle.AService.test())")
    public void before(JoinPoint jp) {
        System.out.println("before....");
    }
}
