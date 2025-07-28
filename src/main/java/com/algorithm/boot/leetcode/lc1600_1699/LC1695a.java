package com.algorithm.boot.leetcode.lc1600_1699;

import java.util.HashSet;
import java.util.Set;

public class LC1695a {
    /**
     * <a href="https://leetcode.cn/problems/maximum-erasure-value/">1695. 删除子数组的最大得分</a>
     * 中等<pre>
     * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
     *
     * 返回 只删除一个 子数组可获得的 最大得分 。
     *
     * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
     *
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^4
     * </pre>
     * @param nums
     * @return
     */
    public int maximumUniqueSubarray(int[] nums) {
        int maxSum = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
            set.add(nums[r]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
