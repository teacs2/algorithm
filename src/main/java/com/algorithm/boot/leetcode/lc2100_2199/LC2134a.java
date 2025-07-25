package com.algorithm.boot.leetcode.lc2100_2199;

public class LC2134a {
    /**
     * 2134. 最少交换次数来组合所有的 1 II
     * @param nums
     * @return
     */
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int k = 0;
        for (int num : nums) {
            if (num == 1) {
                k++;
            }
        }
        if (k == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < n + k - 1; i++) {
            if (nums[i % n] == 0) {
                cnt++;
            }
            if (i < k - 1) {
                continue;
            }
            res = Math.min(res, cnt);
            cnt -= nums[(i - k + 1) % n] == 0 ? 1 : 0;
        }
        return res;
    }
}
