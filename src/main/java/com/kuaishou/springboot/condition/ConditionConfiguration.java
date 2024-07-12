package com.kuaishou.springboot.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-05-13
 */
@Configuration
@ConditionalOnBean(ConditionMark.class)
public class ConditionConfiguration {

    @Bean
    public ConditionBean conditionBean() {
        return new ConditionBean();
    }
}
