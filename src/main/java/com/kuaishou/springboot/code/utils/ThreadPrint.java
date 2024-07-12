package com.kuaishou.springboot.code.utils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-09-07
 */
public class ThreadPrint {

    private static int num;
    private static final Object obj = new Object();

    public static void main(String[] args) {
        new Thread(() -> printNum(0)).start();
        new Thread(() -> printNum(1)).start();
        new Thread(() -> printNum(2)).start();
    }

    private static void printNum(int i) {
        synchronized (obj) {
            while (num < 100) {
                while (num % 3 != i) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ":" + num++);
                obj.notifyAll();
            }
        }
    }


    private static void printNum(int i, String x) {
        while (true) {
            synchronized (obj) {
                while (num % 3 != i) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(x);
                ++num;
                obj.notifyAll();
            }
        }
    }
}
