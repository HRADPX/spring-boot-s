package com.kuaishou.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kuaishou.springboot.model.Material;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-09
 */
@Configuration
public class BeanConfiguration {

    @Bean("material")
    public Material materialV1() {
        Material material = new Material();
        material.id = 200;
        return material;
    }

    @Bean("material")
    public Material material() {
        Material material = new Material();
        material.id = 100;
        return material;
    }

    @Bean("material")
    public Material materialV2() {
        Material material = new Material();
        material.id = 300;
        return material;
    }

}
