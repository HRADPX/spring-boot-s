package com.kuaishou.springboot.factory;

import org.springframework.beans.factory.FactoryBean;

import com.kuaishou.springboot.service.SelectOptService;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-01-06
 */
//@Component
public class SpringFactoryBean implements FactoryBean<SelectOptService> {
    @Override
    public SelectOptService getObject() {
        return new SelectOptService();
    }

    @Override
    public Class<?> getObjectType() {
        return SelectOptService.class;
    }
}
