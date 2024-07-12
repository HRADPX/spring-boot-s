package com.kuaishou.springboot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-19
 */
@EnableAsync
@SpringBootApplication(scanBasePackages = "com.kuaishou.springboot.circle")
public class CircleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircleApplication.class, args);
    }
}
