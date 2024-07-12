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
 * Created on 2022-07-31
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface ComponentEnhance {

    @AliasFor(annotation = Component.class)
    String value() default "";

    String handlerName() default "";
}
