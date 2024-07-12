package com.kuaishou.springboot.test;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.Factory;

import com.kuaishou.springboot.proxy.EnhanceInterface;
import com.kuaishou.springboot.proxy.EnhancerInterceptor;
import com.kuaishou.springboot.proxy.EnhancerService;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-01-04
 */
public class EnhancerTest {

    public static void main(String[] args) {

//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/hr/code");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerService.class);
        enhancer.setCallback(new EnhancerInterceptor());
        enhancer.setInterfaces(new Class[] { EnhanceInterface.class });

        EnhancerService enhancerService = (EnhancerService) enhancer.create();
        System.out.println(enhancerService.getClass());
        System.out.println(enhancerService.execute("cglib"));
        Class<?>[] interfaces = enhancerService.getClass().getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getSimpleName());
        }
        System.out.println(enhancerService.getClass().isAssignableFrom(Factory.class));
    }
}
