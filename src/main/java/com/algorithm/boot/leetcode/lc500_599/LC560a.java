package com.algorithm.boot.leetcode.lc500_599;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/subarray-sum-equals-k/description/">560. 和为 K 的子数组 中等</a>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 */
public class LC560a {
    /**
     * 前缀和
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int s = 0;
        Map<Integer, Integer> cnt = new HashMap<>(nums.length + 1);
        cnt.put(0, 1);
        for (int num : nums) {
            s += num;
            ans += cnt.getOrDefault(s - k, 0);
            cnt.merge(s, 1, Integer::sum);
        }
        return ans;
    }
}
