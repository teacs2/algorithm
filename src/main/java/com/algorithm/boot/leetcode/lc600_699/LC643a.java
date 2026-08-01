package com.algorithm.boot.leetcode.lc600_699;

/**
 * 643. 子数组最大平均数 I
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 示例 2：
 * <p>
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length,
 * 1 <= k <= n <= 10^5,
 * -10^4 <= nums[i] <= 10^4
 */
public class LC643a {

    public double findMaxAverage1(int[] nums, int k) {
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
