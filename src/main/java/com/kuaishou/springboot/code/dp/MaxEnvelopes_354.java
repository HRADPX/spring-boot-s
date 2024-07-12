package com.kuaishou.springboot.code.dp;

import java.util.Arrays;

import com.kuaishou.springboot.code.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-07-05
 */
public class MaxEnvelopes_354 {

    // [[5,4],[6,4],[6,7],[2,3]]
    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes.length <= 1) return envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> o1[0] - o2[0] == 0 ? o2[1] - o1[1] : o1[0] - o2[0]);

        int[] ans = new int[envelopes.length];
        ans[0] = envelopes[0][1];
        int index = 0;

        // 类似最长递增子序列
        for (int[] envelope : envelopes) {
            if (envelope[1] > ans[index]) {
                ans[++index] = envelope[1];
            } else {
                int idx = binarySearch(ans, index, envelope[1]);
                ans[idx] = envelope[1];
            }
        }
        return ++index;
    }

    // 20230701 dp超时
    public int maxEnvelopesV1(int[][] envelopes) {

        if (envelopes.length <= 1) return envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> o1[0] - o2[0] == 0 ? o2[1] - o1[1] : o1[0] - o2[0]);
        System.out.println(Arrays.deepToString(envelopes));

        int[] dp = new int[envelopes.length];
        int max = 0;

        for (int i = 0; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private int binarySearch(int[] nums, int high, int key) {

        int low = 0;
        while (low <= high) {

            int mid = (low + high) >>> 1;
            if (nums[mid] == key) return mid;

            if (nums[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {

//        int[][] nums = {{5,4},{6,4},{6,7},{2,3}};
        int[][] nums = {{4,5},{6,7},{2,3}};
//        int[][] nums = {{30,50},{12,2},{3,4},{12,15}};
        System.out.println(ReflectUtils.getInstance(MaxEnvelopes_354.class).maxEnvelopes(nums));
        System.out.println(ReflectUtils.getInstance(MaxEnvelopes_354.class).maxEnvelopesV1(nums));
    }

}
