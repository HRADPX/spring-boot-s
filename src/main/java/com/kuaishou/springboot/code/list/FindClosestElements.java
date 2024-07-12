package com.kuaishou.springboot.code.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-05-10
 */
public class FindClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        if (arr == null || arr.length == 0|| k <= 0 || k > arr.length) {
            return Collections.emptyList();
        }

        if (k == arr.length) {
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }
        List<Integer> rs = new ArrayList<>();

        // 二分找到最接近 x 的下标
        int minIdx = binarySearch(arr, 0, arr.length - 1, x);
        int low, high;
        if (minIdx == arr.length || minIdx == 0) {
            low = minIdx == arr.length ? minIdx - k : 0;
            high = minIdx == arr.length ? minIdx - 1 : k - 1;
            for (int i = low; i <= high; i++) {
                rs.add(arr[i]);
            }
            return rs;
        }

        minIdx = arr[minIdx] - x < x - arr[minIdx - 1] ? minIdx : minIdx - 1;
        low = minIdx - 1;
        high = minIdx + 1;
        int minSubtract;

        while (high - low - 1 < k) {

            if (low >= 0 && high < arr.length) {
                minSubtract = Math.min(Math.abs(arr[high] - x), Math.abs(arr[low] - x));
            } else if (low >= 0) {
                while (low >= 0 && high - low - 1 < k) {
                    low--;
                }
                break;
            } else {
                while (high < arr.length && high - low - 1 < k) {
                    high++;
                }
                break;
            }
            if (x - arr[low] > arr[high] - x) {
                while (high < arr.length && Math.abs(arr[high] - x) == minSubtract && high - low - 1 < k) {
                    high++;
                }
            } else {
                while (low >= 0 && Math.abs(arr[low] - x) == minSubtract && high - low - 1 < k) {
                    low--;
                }
            }
        }
        for (int i = low + 1; i <= high - 1; i++) {
            rs.add(arr[i]);
        }
        return rs;
    }

    private static int binarySearch(int[] array, int low, int high, int x) {

        while (low <= high) {
            int mid = (high + low) >> 1;
            if (array[mid] == x) {
                return mid;
            }
            if (array[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // 逆向思维: 找符合条件的 = 全集 - 不符合条件的
    public static List<Integer> findClosestElementsV1(int[] arr, int k, int x) {

        if (arr == null || arr.length == 0|| k <= 0 || k > arr.length) {
            return Collections.emptyList();
        }

        int low = 0;
        int high = arr.length - 1;
        int removeElementCounts = arr.length - k;

        while (removeElementCounts > 0) {

            if (Math.abs(x - arr[low]) > Math.abs(x - arr[high])) {
                low++;
            } else {
                high--;
            }
            removeElementCounts--;
        }

        List<Integer> rs = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            rs.add(arr[i]);
        }
        return rs;
    }

    public static void main(String[] args) {

        int[] array = {0,0,1,2,3,3,4,7,7,8};
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {1,3};
        int[] array3 = {1,1,1,1,1};
        System.out.println(findClosestElementsV1(array2, 1, 2));
        System.out.println(findClosestElementsV1(array, 3, 5));
        System.out.println(findClosestElementsV1(array1, 4, 3));

//        System.out.println(binarySearch(array3, 0, array3.length - 1, -1));
    }
}
