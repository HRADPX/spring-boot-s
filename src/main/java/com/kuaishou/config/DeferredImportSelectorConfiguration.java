package com.kuaishou.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kuaishou.springboot.model.DeferredImportSelectorMark;
import com.kuaishou.springboot.model.DeferredImportSelectorSignal;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-05-18
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnBean(DeferredImportSelectorMark.class)
public class DeferredImportSelectorConfiguration {

    @Bean
    public DeferredImportSelectorSignal deferredImportSelectorSignal() {
        return new DeferredImportSelectorSignal();
    }
}