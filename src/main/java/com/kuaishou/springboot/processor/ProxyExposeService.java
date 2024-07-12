package com.kuaishou.springboot.processor;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-02-14
 */
@Service
@Slf4j
public class ProxyExposeService {

    public void execute(String s) {
        ((ProxyExposeService) AopContext.currentProxy()).execute0(s);
        log.info("execute log: {}", s);
    }

    public void execute0(String s) {
        log.info("execute0 log: {}", s);
    }
}
