package com.algorithm.boot.leetcode.lc2400_2499;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC2461a {
    /**
     * <a href="https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/">
     *     2461. 长度为 K 子数组中的最大和</a>中等
     <p>给你一个整数数组 <code>nums</code> 和一个整数 <code>k</code> 。请你从 <code>nums</code> 中满足下述条件的全部子数组中找出最大子数组和：</p>
     <ul>
     <li>子数组的长度是 <code>k</code>，且</li>
     <li>子数组中的所有元素 <strong>各不相同</strong> 。</li>
     </ul>
     <p>返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 <code>0</code> 。</p>
     <p><strong>子数组</strong> 是数组中一段连续非空的元素序列。</p>
     * @param nums  整数数组 nums
     * @param k     整数 k
     * @return      最大子数组和
     */
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.merge(nums[i], 1, Integer::sum);
            if (i < k - 1) {
                continue;
            }
            if (map.size() == k) {
                res = Math.max(res, sum);
            }
            sum -= nums[i - k + 1];
            map.merge((nums[i - k + 1]), -1, Integer::sum);
            if (map.get(nums[i - k + 1]) <= 0) {
                map.remove(nums[i - k + 1]);
            }
        }
        return res;
    }
}
