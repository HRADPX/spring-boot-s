package com.kuaishou.springboot.test;

import java.util.Arrays;

import com.kuaishou.springboot.model.IdType;
import com.kuaishou.springboot.util.CollectionBaseUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-14
 */
public class ApiTest {

    public static void main(String[] args) throws ClassNotFoundException {


        Class<BannerTest> bannerTestClass = BannerTest.class;
        BannerTest bannerTest = new BannerTest();
        String name = bannerTest.getClass().getName();
        System.out.println(name);
        System.out.println(Class.forName(name).isAssignableFrom(BannerTest.class));

        System.out.println("-----------");
        Exception exception = new Exception();
        RuntimeException runtimeException = new RuntimeException();
        System.out.println(exception.getClass().isAssignableFrom(runtimeException.getClass()));
        System.out.println(runtimeException.getClass().isAssignableFrom(exception.getClass()));

        System.out.println("-----------");
        System.out.println("".getClass().isAssignableFrom(String.class));
        System.out.println(String.class.isAssignableFrom("".getClass()));


        System.out.println("---------------------------------");
        System.out.println(IdType.class.isAssignableFrom(Enum.class));
        System.out.println(Enum.class.isAssignableFrom(IdType.class));
        System.out.println(IdType.class.getSuperclass());
        System.out.println(CollectionBaseUtils.getEnumValues(IdType.class));
        System.out.println(Arrays.asList(IdType.class.getEnumConstants()));
//        System.out.println(Arrays.asList(BannerTest.class.getEnumConstants()));


        System.out.println(2.7*1.21*0.07);
    }
}
