package com.kuaishou.springboot.code.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.collect.Lists;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-06-07
 */
public class GenericsTest {

    public static void main(String[] args) {


        List<? extends Number> foo1 = new ArrayList<>();
        List<? extends Number> foo2 = new ArrayList<Integer>();
        List<? extends Number> foo3 = new ArrayList<Double>();

        List<Super> list0 = new ArrayList<>();
        List<? extends Current> list1 = new ArrayList<Current>();
        List<? extends Current> list2 = new ArrayList<Child>();
        List<? extends Current> list3 = new ArrayList<>();

        List<? super Current> list4 = new ArrayList<Super>(); // 接受所有 Super 以及 Super 的子类
        List<? super Current> list5 = new ArrayList<>();
        List<? super Current> list6 = new ArrayList<Object>();

        list1.add(null);
//        list1.add(new Super());
//        list2.add(new Current());
//        list3.add(new Child());

        list4.add(new Current());
        list4.add(new Child());
        list5.add(new Child());
        list5.add(new Current());
        list6.add(new Child());
        list6.add(new Current());

        queryList().forEach(ssuper -> {
            if (ssuper instanceof Current) {
                System.out.println("ssuper is Current");
            }
        });

        List<Child> childList = Lists.newArrayList();
        IntStream.range(0, 32).forEach(i -> childList.add(new Child()));
        List<Super> copyList = Lists.newArrayList();
        System.out.println("childList size: " + childList.size());
        System.out.println("copyList size: " + copyList.size());
        Collections.copy(copyList, childList);
        System.out.println("copyList size: " + copyList.size());

        int[] array = new int[] {1};
        List<Integer> collect = Arrays.stream(array).boxed().collect(Collectors.toList());
        int[] ints = collect.stream().mapToInt(Integer::intValue).toArray();


    }

    @SuppressWarnings("unchecked")
    public static <T extends Super> List<T> queryList() {
        List<T> list = Lists.newArrayList();
        list.add((T) new Current());
        return list;
    }


    static class Super {}
    static class Current extends Super {}
    static class Child extends Current {}
}
