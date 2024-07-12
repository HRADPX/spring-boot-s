package com.kuaishou.springboot.runner;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.kuaishou.springboot.binlog.ConsumerV1;
import com.kuaishou.springboot.model.Material;
import com.kuaishou.springboot.prototype.ProtoTypeBean;
import com.kuaishou.springboot.service.MaterialService;
import com.kuaishou.springboot.trx.BeanService;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-15
 */
@Component
public class SpringBootRunner implements ApplicationRunner, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private ConsumerV1 binlogConsumer;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private BeanService beanService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("------------------");
        binlogConsumer.resolve("gifshow", new Material());
        beanService.execute("aa");
//        System.out.println(materialService.insertMaterialService(new Material()));
//        System.out.println(materialService.insertMaterialService(new Material()));
        System.out.println("protoType:" + applicationContext.getBean(ProtoTypeBean.class));
        System.out.println("protoType:" + applicationContext.getBean(ProtoTypeBean.class));
        System.out.println("protoType:" + applicationContext.getBean(ProtoTypeBean.class));
        System.out.println("protoType:" + applicationContext.getBean(ProtoTypeBean.class));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
