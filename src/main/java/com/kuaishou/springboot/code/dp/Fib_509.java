package com.kuaishou.springboot.code.dp;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-05
 */
public class Fib_509 {

    public int fib(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public int fibV1(int n) {

        if (n == 0) {
            return 0;
        }
        int pp = 0;
        int p = 1;
        int c = 1;

        for (int i = 2; i <= n; i++) {
            c = p + pp;
            pp = p;
            p = c;
        }
        return c;
    }

    public static void main(String[] args) {

        Fib_509 instance = ReflectUtils.getInstance(Fib_509.class);
        System.out.println(instance.fib(30));
        System.out.println(instance.fibV1(30));
        System.out.println(instance.fibV1(2));
    }
}
