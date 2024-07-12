package com.kuaishou.springboot.code.doublePos;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-16
 */
public class FindMedianSortedArrays_04 {

    /**
     * two sorted array
     * O(m + n) Solution
     */
    public static double findMedianSortedArrays$(int[] nums1, int[] nums2) {
        int l1 = nums1.length; int l2 = nums2.length;
        int left = 0; int right = 0;
        int i = 0; int j = 0;
        double ans = 0.0;

        while (i < l1 || j < l2) {
            left = right;
            if (i < l1 && j < l2) {
                if (nums1[i] < nums2[j])
                    right = nums1[i++];
                else
                    right = nums2[j++];
            } else if (i == l1)
                right = nums2[j++];
            else if (j == l2)
                right = nums1[i++];
            if (i + j == (l1 + l2 + 2) >> 1) {
                ans = ((l1 + l2) & 1) == 1 ? right : (left + right) / 2.0;
                break;
            }
        }
        return ans;
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length; int l2 = nums2.length;
        int left = (l1 + l2 + 1) >> 1;
        int right = (l1 + l2 + 2) >> 1;
        return (findMedianSortedArrays0(nums1, 0, l1 - 1, nums2, 0, l2 - 1, left)
                + findMedianSortedArrays0(nums1, 0, l1 - 1, nums2, 0, l2 - 1, right)) / 2.0;
    }
    private static double findMedianSortedArrays0(int[] nums1, int l1, int h1, int[] nums2, int l2, int h2, int k) {

        int len1 = h1 - l1 + 1;
        int len2 = h2 - l2 + 1;
        if (len1 > len2) return findMedianSortedArrays0(nums2, l2, h2, nums1, l1, h1, k);

        if (len1 == 0) return nums2[k + l2 - 1];
        if (k == 1) return Math.min(nums1[l1], nums2[l2]);

        int idx1 = Math.min(k / 2, len1) + l1 - 1;
        int idx2 = k / 2 + l2 - 1;

        if (nums1[idx1] < nums2[idx2])
            return findMedianSortedArrays0(nums1, idx1 + 1, h1, nums2, l2, h2, k - (idx1 - l1 + 1));
        return findMedianSortedArrays0(nums1, l1, h1, nums2, idx2 + 1, h2, k - (idx2 - l2 + 1));

    }


    public static void main(String[] args) {

        int[] nums1 = {1};
        int[] nums2 = {10,11};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
