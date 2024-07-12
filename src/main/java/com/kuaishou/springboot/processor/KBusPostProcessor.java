package com.kuaishou.springboot.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import com.kuaishou.springboot.annotation.chain.AutowiredEnhance;
import com.kuaishou.springboot.annotation.chain.ComponentEnhance;
import com.kuaishou.springboot.service.ApplicationService;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-17
 */
@Component
@Order(Ordered.LOWEST_PRECEDENCE - 10)
public class KBusPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        ReflectionUtils.doWithMethods(bean.getClass(), method -> {
            AnnotationAttributes annotation1 = findAnnotation(method, AutowiredEnhance.class);
            AnnotationAttributes annotation2 = findAnnotation(method, ComponentEnhance.class);
            if (annotation1 == null || annotation2 == null) {
                return;
            }
            boolean present = Arrays.stream(method.getParameterTypes())
                    .anyMatch(type -> ClassUtils.isAssignable(ApplicationService.class, type));
            if (!present) {
                throw new IllegalStateException("xxx");
            }
        });
        return bean;
    }


    private AnnotationAttributes findAnnotation(AccessibleObject ao, Class<? extends Annotation> annotationClass) {
        if (ao.getAnnotations().length > 0) {
            return AnnotatedElementUtils.getMergedAnnotationAttributes(ao, annotationClass);
        }
        return null;
    }
}
