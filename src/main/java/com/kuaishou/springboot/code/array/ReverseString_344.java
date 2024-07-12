package com.kuaishou.springboot.code.array;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-24
 */
public class ReverseString_344 {

    public void reverseString(char[] cs) {
        
        if (cs == null || cs.length <= 1)
            return;
        
        int low = 0;
        int high = cs.length - 1;
        
        while (low < high) {
            char c = cs[low];
            cs[low] = cs[high];
            cs[high] = c;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {

        char[] chars = "olleh".toCharArray();
        ReflectUtils.getInstance(ReverseString_344.class).reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }
}
