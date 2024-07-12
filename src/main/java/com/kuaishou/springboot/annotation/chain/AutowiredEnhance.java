package com.kuaishou.springboot.annotation.chain;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-07-31
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Autowired
public @interface AutowiredEnhance {

    /**
     * 需要过滤的 handlerName
     * @see ComponentEnhance#handlerName()
     */
    String[] excludeNames() default {};

    /** 指定需要过滤的 Handler 类型 */
    Class<?>[] excludeClasses() default {};
}
