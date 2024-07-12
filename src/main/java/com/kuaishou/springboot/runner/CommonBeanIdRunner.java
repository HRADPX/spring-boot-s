package com.kuaishou.springboot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kuaishou.springboot.model.Material;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-09
 */
@Component
public class CommonBeanIdRunner implements CommandLineRunner {


    @Autowired
    private Material material;


    @Override
    public void run(String... args) throws Exception {

        System.out.println("common bean:" + material);
    }
}
