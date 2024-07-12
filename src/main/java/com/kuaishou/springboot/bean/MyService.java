package com.kuaishou.springboot.bean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-28
 */
@Service
public class MyService {

    // 按照 name
    @Resource
    private BaseService serviceImpl1;

    @PostConstruct
    public void init() {
        System.out.println(serviceImpl1.getClass().getSimpleName());
    }
}
