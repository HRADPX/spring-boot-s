package com.kuaishou.springboot.test;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-16
 */
public class Solution1 {

    // 两个线程交替打印1-100的数字
    //  比如：
    //  线程A：1
    //  线程B：2
    //  线程A：3
    //  线程B：4

    private static int num = 1;
    private static Object lock = new Object();

    public static void main(String[] args) {


        new Thread(() -> {
            while (num < 100) {
                synchronized (lock) {
                    while ((num & 1) != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            // ignore ex
                        }
                    }
                    if (num <= 100) {
                        System.out.println(num++);
                    }
                    lock.notifyAll();
                }
            }
        }, "A").start();

        new Thread(() -> {
            while (num < 100) {
                synchronized (lock) {
                    while ((num & 1) != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            // ignore ex
                        }
                    }
                    if (num <= 100) {
                        System.out.println(num++);
                    }
                    lock.notifyAll();
                }
            }
        }, "B").start();
    }
}
