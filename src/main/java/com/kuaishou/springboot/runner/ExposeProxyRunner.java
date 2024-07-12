package com.kuaishou.springboot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.kuaishou.springboot.processor.ProxyExposeService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-02-14
 */
@Slf4j
//@Service
public class ExposeProxyRunner implements ApplicationRunner {

    @Autowired
    private ProxyExposeService proxyExposeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("expose proxy runner begin.......");
        proxyExposeService.execute0("origin execute0");
        proxyExposeService.execute("expose  proxy");
        log.info("expose proxy runner end.......");
    }
}
