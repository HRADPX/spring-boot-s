package com.kuaishou.springboot.code.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-07
 */
public class AdvantageCount_870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);

        List<List<Integer>> numIdxList = new ArrayList<>(nums1.length);

        for (int i = 0; i < nums2.length; i++)
            numIdxList.add(Arrays.asList(nums2[i], i));

        int[] rs = new int[nums1.length];

        numIdxList.sort((l1, l2) -> l2.get(0) - l1.get(0));
        System.out.println(numIdxList);

        int right = nums1.length - 1;
        int left = 0;

        for (List<Integer> nums2List : numIdxList) {

            if (nums1[right] > nums2List.get(0)) {
                // 进行比较
                rs[nums2List.get(1)] = nums1[right];
                right--;
            } else {
                // 找一个最差的
                rs[nums2List.get(1)] = nums1[left++];
            }
        }
        return rs;
    }

    public static void main(String[] args) {

//         * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
// * 输出：[2,11,7,15]
// *
// *
// * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
// * 输出：[24,32,8,12]
        int[] nums1 = {2,0,4,1,2};
        int[] nums2 = {1,3,0,0,2};

        int[] rs = ReflectUtils.getInstance(AdvantageCount_870.class).advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(rs));

    }
}
