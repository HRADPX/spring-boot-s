package com.kuaishou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kuaishou.springboot.model.DeferredImportSelectorMark;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-05-18
 */
@Configuration(proxyBeanMethods = false)
public class BootConfiguration {

    @Bean
    public DeferredImportSelectorMark deferredImportSelectorMark() {
        return new DeferredImportSelectorMark();
    }
}
