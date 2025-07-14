package com.algorithm.boot.leetcode.lc600_699;

public class LC643a {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < k - 1) {
                continue;
            }
            maxSum = Math.max(maxSum, sum);
            sum -= nums[i - k + 1];
        }
        return (double) maxSum / k;
    }
}
