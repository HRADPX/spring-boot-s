package com.kuaishou.springboot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.kuaishou.springboot.factory.SpringFactoryBean;
import com.kuaishou.springboot.service.SelectOptService;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-01-06
 */
//@Service
public class FactoryBeanRunner implements ApplicationRunner {

    @Autowired
    private SelectOptService selectOptService;
    @Autowired
    private SpringFactoryBean springFactoryBean;


    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
