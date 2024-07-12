package com.kuaishou.springboot.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.kuaishou.springboot.annotation.chain.AutowiredEnhance;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-01
 */
@Service
@Slf4j
public class HandlerBizService {

    private final MaterialService materialService;

    public HandlerBizService(MaterialService materialService) {
        this.materialService = materialService;
    }

    @AutowiredEnhance(excludeNames = "bbbb")
    private List<Handler> handlerList;


    @PostConstruct
    public void init() {
        log.info("-------: {}", handlerList);
    }
}
