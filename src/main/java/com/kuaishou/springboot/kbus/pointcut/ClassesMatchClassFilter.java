package com.kuaishou.springboot.kbus.pointcut;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.aop.ClassFilter;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-10-13
 */
public class ClassesMatchClassFilter implements ClassFilter {

    private final List<Class<?>> classTypeList = new ArrayList<>();

    public ClassesMatchClassFilter(List<Class<?>> classTypeList) {
        Assert.notNull(classTypeList, "classTypeList must not be null!");
        this.classTypeList.addAll(classTypeList);
    }

    public void addClassType(Class<?> classType) {
        Assert.notNull(classType, "classType must not be null!");
        this.classTypeList.add(classType);
    }

    @Override
    public boolean matches(Class<?> clazz) {
        for (Class<?> classType : classTypeList) {
            if (ClassUtils.isAssignable(classType, clazz)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClassesMatchClassFilter)) {
            return false;
        }
        return CollectionUtils.containsAll(((ClassesMatchClassFilter) other).classTypeList, classTypeList);
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (Class<?> classType : classTypeList) {
            hashCode = hashCode * 31 + 7 * classType.hashCode();
        }
        return hashCode;
    }

    @Override
    public String toString() {
        return getClass().getName() + ": " + this.classTypeList;
    }
}
