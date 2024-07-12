package com.kuaishou.springboot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.kuaishou.springboot.configuration.ApplicationProxyConfiguration;
import com.kuaishou.springboot.configuration.KBusConfiguration;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-01-24
 */
@Service
public class OrderConfigurationApplicationRunner implements ApplicationRunner {

    @Autowired
    private ApplicationProxyConfiguration applicationProxyConfiguration;
    @Autowired
    private KBusConfiguration kBusConfiguration;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("---" + applicationProxyConfiguration);
        System.out.println("---" + kBusConfiguration);
    }
}
