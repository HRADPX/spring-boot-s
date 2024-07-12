package com.kuaishou.springboot.binlog;

import org.springframework.stereotype.Component;

import com.kuaishou.springboot.model.Material;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-15
 */
@Component
public class BinlogConsumer implements ConsumerV1 {

    @Override
    public void resolve(String name, Material type) {
        System.out.println("方法执行....");
//        System.out.println(dataSource + table + type);
    }
}
