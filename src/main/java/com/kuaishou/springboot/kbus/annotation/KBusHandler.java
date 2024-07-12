package com.kuaishou.springboot.kbus.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-19
 * KBus 更新消息过滤, 只有更新的字段中完全包含 {@link #includeFields()} 时才进行 binlog 消费
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface KBusHandler {

    /**
     * 需要消费的字段的变更，支持驼峰和下划线
     */
    String[] includeFields() default {};
}
