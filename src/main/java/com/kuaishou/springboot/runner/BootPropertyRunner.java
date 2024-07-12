package com.kuaishou.springboot.runner;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.kuaishou.springboot.condition.ConditionBean;
import com.kuaishou.springboot.properties.ConfigTreeProperties;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-04-27
 */
@Component
@Slf4j
public class BootPropertyRunner implements CommandLineRunner, ApplicationContextAware {

    @Autowired
    private Environment environment;
    @Autowired
    private ConfigTreeProperties configTreeProperties;
    @Autowired
    private ConditionBean conditionBean;

    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
//        log.info("boot property runner run.....");
//        log.info("userName: {}, password: {}", configTreeProperties.getUserName(), configTreeProperties.getPassword());
//        log.info("logSystem: {}", environment.getProperty("org.springframework.boot.logging.LoggingSystem"));
//        log.info("conditionBean: {}", conditionBean);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
