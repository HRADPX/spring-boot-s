package com.kuaishou.springboot.test;

import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

import com.google.common.collect.Sets;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-09-06
 */
public class LockSupportTest {


    public static void main(String[] args) {


//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
//        executorService.schedule(() -> System.out.println("----"), 5, TimeUnit.SECONDS);
        Set<Long> photoIds = Sets.newHashSet(1L, 2L, 3L, 4L);
        Set<Long> queryPhotoIds = Sets.newHashSet(3L, 4L);
        Set<Long> additionalPhotoIds = Sets.newHashSet(CollectionUtils.subtract(photoIds, queryPhotoIds));
        System.out.println(additionalPhotoIds);

    }


    private static class Node {
        Object o;

        public void add() {
            System.out.println("add element: " + o);
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}
