package com.kuaishou.springboot.annotation.chain;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-01
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@ComponentEnhance
public @interface ServiceEnhance {

    @AliasFor(annotation = Component.class)
    String value() default "";

    @AliasFor(annotation = ComponentEnhance.class, value = "handlerName")
    String handlerName() default "";
}
