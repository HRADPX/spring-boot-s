package com.kuaishou.springboot.service;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-31
 */
@Service
@Scope(value = SCOPE_PROTOTYPE)
public class CommandService {

    public void execute() {
        System.out.println(this);
    }
}
