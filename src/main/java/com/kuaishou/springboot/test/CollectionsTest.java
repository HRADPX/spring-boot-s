package com.kuaishou.springboot.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-11-30
 */
public class CollectionsTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        for (int i = 0; i < 100; i++) {
            Collections.shuffle(list);
            System.out.println(list);
        }
    }
}
