package com.kuaishou.springboot.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kuaishou.springboot.properties.NacosConfigProperties;
import com.kuaishou.springboot.properties.NacosConfigPropertiesV1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-23
 */
@Slf4j
@Component
public class AutowiredRunner implements CommandLineRunner {

    private final NacosConfigProperties nacosConfigProperties;
    private final NacosConfigPropertiesV1 nacosConfigPropertiesV1;

    public AutowiredRunner(NacosConfigProperties nacosConfigProperties,
            NacosConfigPropertiesV1 nacosConfigPropertiesV1) {
        this.nacosConfigProperties = nacosConfigProperties;
        this.nacosConfigPropertiesV1 = nacosConfigPropertiesV1;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("nacosConfigProperties: " + nacosConfigProperties);
        System.out.println("nacosConfigPropertiesV1: " + nacosConfigPropertiesV1);
    }
}
