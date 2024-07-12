package com.kuaishou.springboot.prototype;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-07
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProtoTypeBean {
}
