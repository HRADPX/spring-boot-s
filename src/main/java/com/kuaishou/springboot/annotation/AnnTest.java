package com.kuaishou.springboot.annotation;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-02-24
 */
public class AnnTest {

    public static void main(String[] args) {

        Class<Sub> clazz = Sub.class;
        Arrays.stream(clazz.getDeclaredAnnotations()).forEach(System.out::println);
    }
}
