package com.kuaishou.springboot.kbus.advisor;

import java.util.List;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMethodMatcher;
import org.springframework.util.Assert;

import com.google.common.collect.ImmutableList;
import com.kuaishou.springboot.kbus.annotation.KBusHandler;
import com.kuaishou.springboot.kbus.inter.KBusAffinityResolver;
import com.kuaishou.springboot.kbus.inter.KBusResolver;
import com.kuaishou.springboot.kbus.pointcut.ClassesMatchClassFilter;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-19
 *
 * 只对 KBus 两种接口进行拦截处理
 */
public class KBusAnnotationAdvisor extends DefaultPointcutAdvisor {

    private static final List<Class<?>> KBUS_CLASS_TYPE_LIST =
            ImmutableList.of(KBusResolver.class, KBusAffinityResolver.class);

    private static final int DEFAULT_ORDER = Integer.MAX_VALUE - 10;

    public KBusAnnotationAdvisor(KBusHandlerInterceptor advice) {
        this(getPointCut(), advice);
    }

    public KBusAnnotationAdvisor(Pointcut pointcut, KBusHandlerInterceptor advice) {
        Assert.notNull(pointcut, "Pointcut must not be null");
        Assert.notNull(advice, "Advice must not be null");
        super.setPointcut(pointcut);
        super.setAdvice(advice);
        super.setOrder(DEFAULT_ORDER);
    }


    public static Pointcut getPointCut() {
        AnnotationMethodMatcher methodMatcher = new AnnotationMethodMatcher(KBusHandler.class);
        ClassesMatchClassFilter classFilter = new ClassesMatchClassFilter(KBUS_CLASS_TYPE_LIST);
        return new ComposablePointcut(classFilter, methodMatcher);
//        AnnotationMatchingPointcut kBusHandlerPointCut = AnnotationMatchingPointcut.forMethodAnnotation(KBusHandler.class);
//        ClassMatcherPointCut classMatcherPointCut = new ClassMatcherPointCut(KBUS_CLASS_TYPE_LIST);
//        return (new ComposablePointcut(kBusHandlerPointCut)).intersection((ClassFilter) classMatcherPointCut);
    }
}