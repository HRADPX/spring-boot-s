package com.kuaishou.springboot.qualifier.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-12-08
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface TypeQualifier {

    FormatType type();

    enum FormatType {
        COMMON, UNIQUE, ABSOLUTELY
    }
}
