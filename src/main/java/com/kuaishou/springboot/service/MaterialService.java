package com.kuaishou.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kuaishou.springboot.model.Material;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-11-30
 */
@Service
public class MaterialService {

    public MaterialService() {
        System.out.println("materialService init....");
    }

    @Value("${name}")
    private String name;

    public String insertMaterialService(Material material) {
        if (material == null) {
            return "";
        }
        return name;
    }
}
