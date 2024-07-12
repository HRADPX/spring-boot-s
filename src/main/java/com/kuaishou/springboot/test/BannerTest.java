package com.kuaishou.springboot.test;

import com.kuaishou.springboot.banner.SpringBootBanner;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-07
 */
public class BannerTest {

    public static void main(String[] args) {

        SpringBootBanner springBootBanner = new SpringBootBanner();
        springBootBanner.printBanner(System.out);
    }
}
