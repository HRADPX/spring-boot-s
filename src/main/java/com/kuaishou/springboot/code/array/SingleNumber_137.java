package com.kuaishou.springboot.code.array;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-09-20
 *
 * 一个整数数组 nums，除某个元素仅出现一次外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * eg. nums = [0,1,0,1,0,1,-1]
 * 需求: 线性时间复杂度的算法且不使用额外空间来解决此问题。
 */
public class SingleNumber_137 {

    /**
     * 思路：将每个数看成32位二进制数，那么每位非 0 即 1，依次统计数组各个 bit 位的数并加和，如果是 3N 表示是出现 3 次的数字贡献的，如果
     * 是 3N + 1，则表示出现一次的数对这个 bit 位有贡献，记录这个 bit 位的数字。
     *
     * 这种解法是其他数字均出现 N 次，仅有一个数字只出现 1 次的通用解法。
     */
    public int singleNumber(int[] nums, int k) {

        if (nums.length == 1) {
            return nums[0];
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
            }
            // 如果是 k * N + 1, 则表示仅出现一次的数对该位有贡献
            res |= (sum % k) << i;
        }
        return res;
    }
}
