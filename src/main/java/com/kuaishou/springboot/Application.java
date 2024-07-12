package com.kuaishou.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;

import com.kuaishou.springboot.code.tree.TreeNodeUtils;
import com.kuaishou.springboot.factory.SpringFactoryBean;
import com.kuaishou.springboot.model.BeanModel;

/**
 * Hello world!
 *
 */
@EnableAsync
//@EnableConfigurationProperties
@SpringBootApplication
@Import(TreeNodeUtils.class)
public class Application {
    public static void main(String[] args ) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Profile("prod")
    public BeanModel getBeanModel() {
        SpringFactoryBean springFactoryBean = springFactoryBean();
        SpringFactoryBean springFactoryBean1 = springFactoryBean();
//        System.out.println("getBeanModel, springFactoryBean ===" + springFactoryBean);
//        System.out.println("getBeanModel, springFactoryBean ===" + springFactoryBean1);
//        System.out.println(springFactoryBean.getObject());
//        System.out.println(springFactoryBean.getObject());
//        System.out.println(springFactoryBean1.getObject());
//        System.out.println(springFactoryBean1.getObject());

        return new BeanModel();
    }

    @Bean
    public SpringFactoryBean springFactoryBean() {
        SpringFactoryBean springFactoryBean = new SpringFactoryBean();
//        System.out.println("springFactoryBean, springFactoryBean ===" + springFactoryBean);
        return springFactoryBean;
    }
}
