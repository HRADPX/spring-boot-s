package com.kuaishou.springboot.code.array;

import java.nio.ByteBuffer;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-02-10
 */
public class SearchRange_34 {

    public static int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length < 1)
            return new int[] {-1, -1};

        int left = halfSearch(nums, target - 0.5);
        int right = halfSearch(nums, target + 0.5);
        return left == right ? new int[]{-1, -1} : new int[]{left, right - 1};
    }


    public static int[] searchRangeV1(int[] nums, int target) {

        if (nums == null || nums.length < 1)
            return new int[] {-1, -1};

        // search left
        int left = searchBound(nums, target, true);
        if (left < 0 || left >= nums.length || nums[left] != target) {
            return new int[] {-1, -1};
        }
        // search right
        int right = searchBound(nums, target, false);
       return new int[] {left, right};
    }

    /**
     * 搜索边界算法
     */
    public static int searchBound(int[] nums, int target, boolean searchLeft) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (searchLeft) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return searchLeft ? low : high;
    }

    public static int halfSearch(int[] nums, double target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
//        System.out.println(Arrays.toString(searchRangeV1(nums, 10)));
//        System.out.println(Arrays.toString(searchRangeV1(nums, 11)));
//        System.out.println(Arrays.toString(searchRangeV1(nums, 8)));
//        System.out.println(Arrays.toString(searchRangeV1(nums, 5)));
//        System.out.println(Arrays.toString(searchRangeV1(nums, 4)));
//        System.out.println(Arrays.toString(searchRangeV1(nums, 6)));

//        System.out.println(sizeOfUnsignedVarint(-128));
//        System.out.println(sizeOfUnsignedVarint(Integer.MIN_VALUE));
//        System.out.println(Integer.toBinaryString(-1));
//        System.out.println("11111111111111111111111111111111".length());


        byte[] array = new byte[] {1, 2, 3, 4};

        ByteBuffer wrap = ByteBuffer.wrap(array);

        System.out.println(wrap.position());
        System.out.println(wrap.limit());
        System.out.println(wrap.capacity());





    }


    public static int sizeOfVarint(int value) {
        return sizeOfUnsignedVarint((value << 1) ^ (value >> 31));
    }


    public static int sizeOfUnsignedVarint(int value) {
        int bytes = 1;
        while ((value & 0xffffff80) != 0L) {
            bytes += 1;
            value >>>= 7;
        }
        return bytes;
    }
}
