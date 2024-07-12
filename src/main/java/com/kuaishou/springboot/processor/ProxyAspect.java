package com.kuaishou.springboot.processor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-02-14
 */
@Aspect
@Component
@Slf4j
public class ProxyAspect {

    @Pointcut("execution(* com.kuaishou.springboot.processor.ProxyExposeService.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        log.info("execute before.....");
    }
}
