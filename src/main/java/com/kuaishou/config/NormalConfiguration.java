package com.kuaishou.config;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-05-18
 */
//@ConditionalOnBean(DeferredImportSelectorMark.class)
//@Configuration
public class NormalConfiguration {

//    @Bean
    public OuterPackage outerPackage() {
        return new OuterPackage();
    }
}
