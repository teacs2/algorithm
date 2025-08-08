package com.algorithm.boot.leetcode.lc1000_1099;

public class LC1004a {

    /**
     * <a href="https://leetcode.cn/problems/max-consecutive-ones-iii/">1004. 最大连续1的个数 III 中等</a> <pre>
     * 给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，则返回执行操作后 数组中连续 1 的最大个数 。
     *
     * 1 <= nums.length <= 10^5
     * nums[i] 不是 0 就是 1
     * 0 <= k <= nums.length
     * </pre>
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int l = 0;
        int cnt = 0;
        for (int r = 0; r < nums.length; r++) {
            cnt += 1 - nums[r];
            while (cnt > k) {
                cnt -= 1 - nums[l++];
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
