package com.kuaishou.springboot.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-01-18
 */
@Service
public class ServiceOfA {
    @Autowired
    private ServiceOfB serviceOfB;

    @PostConstruct
    public void init() {
        System.out.println(serviceOfB);
    }
}
