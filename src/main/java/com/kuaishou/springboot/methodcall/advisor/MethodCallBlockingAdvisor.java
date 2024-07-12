package com.kuaishou.springboot.methodcall.advisor;

import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMethodMatcher;
import org.springframework.util.Assert;

import com.kuaishou.springboot.methodcall.annotation.MethodCallBlockingLimit;


/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-11-11
 */
public class MethodCallBlockingAdvisor extends DefaultPointcutAdvisor {

    private static final int DEFAULT_ORDER = Integer.MAX_VALUE - 11;

    public MethodCallBlockingAdvisor(MethodCallBlockingInterceptor advice) {
        Assert.notNull(advice, "methodCallBlockingInterceptor must not null!");
        super.setPointcut(new ComposablePointcut(new AnnotationMethodMatcher(MethodCallBlockingLimit.class)));
        super.setAdvice(advice);
        super.setOrder(DEFAULT_ORDER);
    }
}
