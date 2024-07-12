package com.kuaishou.springboot.binlog;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;

import com.kuaishou.springboot.model.Material;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-01-24
 */
public interface ConsumerV1 {

    @ConditionalOnWebApplication
    void resolve(String name, Material type);
}
