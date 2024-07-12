package com.kuaishou.springboot.code.stack;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-13
 */
public class MaxNumber_321 {

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] ans = new int[k];

        for (int i = Math.max(0, k - nums1.length); i < Math.min(k, nums1.length); i++) {
            int[] a = findMax(nums1, i);
            int[] b = findMax(nums2, k - i);
            int[] merge = merge(a, b);
            ans = isBigger(merge, ans) ? merge : ans;
        }
        return ans;
    }

    public static boolean isBigger(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) {
                return true;
            } else if (a[i] < b[i]) {
                return false;
            }
        }
        return false;
    }

    public static int[] merge(int[] a, int[] b) {

        if (a.length == 0) return b;
        if (b.length == 0) return a;
        int[] ans = new int[a.length + b.length];
        int index = 0;
        if (a[0] < b[0]) {
            for (int i : b) ans[index++] = i;
            for (int i : a) ans[index++] = i;
        } else {
            for (int i : a) ans[index++] = i;
            for (int i : b) ans[index++] = i;
        }
        return ans;
    }

    private static int[] findMax(int[] nums, int k){

        int[] ans = new int[k];
        int right = 0;
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            while (right > 0 && n - i + right > k && nums[i] > ans[right - 1])
                --right;
            if (right < k) ans[right++] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] array1 = {3, 4, 6, 5};

        System.out.println(Arrays.toString(findMax(array1, 1)));

        int[] array2 = {9, 1, 2, 5, 8, 3};
        System.out.println(Arrays.toString(maxNumber(array1, array2, 3)));
    }
}
