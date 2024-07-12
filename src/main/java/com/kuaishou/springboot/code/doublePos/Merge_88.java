package com.kuaishou.springboot.code.doublePos;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-08-29
 */
public class Merge_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {
            return;
        }
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (i >= 0) nums1[k--] = nums1[i--];
        while (j >= 0) nums1[k--] = nums2[j--];
    }

    public static void main(String[] args) {


        int[] nums1 = {1,5,7,0,0};
        int[] nums2 = {2,6};

        ReflectUtils.getInstance(Merge_88.class).merge(nums1, 3, nums2, 2);
        System.out.println(Arrays.toString(nums1));
    }
}
