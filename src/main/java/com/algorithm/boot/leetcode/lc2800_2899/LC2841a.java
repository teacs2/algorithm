package com.algorithm.boot.leetcode.lc2800_2899;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <a href="https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/">2841. 几乎唯一子数组的最大和 中等</a>
 * 给你一个整数数组 nums 和两个正整数 m 和 k 。
 * 请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。
 * 如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。
 * 子数组指的是一个数组中一段连续 非空 的元素序列。
 */
public class LC2841a {
    public long maxSum(List<Integer> nums, int m, int k) {
        long maxSum = 0;
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            map.merge(nums.get(i), 1, Integer::sum);
            if (map.get(nums.get(i)) <= 1) {
                m--;
            }
            if (i < k - 1) {
                continue;
            }
            if (m <= 0) {
                maxSum = Math.max(maxSum, sum);
            }
            int num = nums.get(i - k + 1);
            sum -= num;
            map.merge(num, -1, Integer::sum);
            if (map.containsKey(num)) {
                if (map.get(num) <= 0) {
                    m++;
                    map.remove(num);
                }
            }
        }
        return maxSum;
    }
}
