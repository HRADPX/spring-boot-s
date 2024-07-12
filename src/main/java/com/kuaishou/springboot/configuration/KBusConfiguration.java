package com.kuaishou.springboot.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kuaishou.springboot.code.tree.TreeNode;
import com.kuaishou.springboot.kbus.advisor.KBusAnnotationAdvisor;
import com.kuaishou.springboot.kbus.advisor.KBusHandlerInterceptor;
import com.kuaishou.springboot.properties.NacosConfigPropertiesV1;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-19
 */
@Configuration
@ConditionalOnBean(TreeNode.class)
public class KBusConfiguration {

    @Bean
    public KBusHandlerInterceptor kBusHandlerInterceptor() {
        return new KBusHandlerInterceptor();
    }

    @Bean
    public KBusAnnotationAdvisor kBusAnnotationAdvisor(KBusHandlerInterceptor advice) {
        return new KBusAnnotationAdvisor(advice);
    }

    @Bean
    @ConfigurationProperties(prefix = "nacos.config.c2")
    public NacosConfigPropertiesV1 nacosConfigPropertiesV1() {
        return new NacosConfigPropertiesV1();
    }


//    @Bean
//    public TreeNode treeNode() {
//        return new TreeNode(1);
//    }
}
