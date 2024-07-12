package com.kuaishou.springboot.test;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-06-17
 */
public class Sigleton {

    private static final Object LOCK = new Object();
    private static int num = 0;

    public static void main(String[] args) {
        new Thread(() -> print("A", 0)).start();
        new Thread(() -> print("B", 1)).start();
        new Thread(() -> print("C", 2)).start();
    }

    private static void print(String str, int mod) {

        for (int i = 0; i < 10; i++) {
            synchronized (LOCK) {
                while ((num % 3) != mod) {
                    try {
                        // block
                        LOCK.wait();
                    } catch (Exception e) {
                        // ignore ex
                    }
                }
                // 可以打印
                System.out.println(str);
                num++;
                LOCK.notifyAll();
            }
        }
    }
}
