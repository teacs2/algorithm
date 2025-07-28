package com.algorithm.boot.leetcode.lc1400_1499;

public class LC1493a {

    /**
     * <a href="https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/description/">1493. 删掉一个元素以后全为 1 的最长子数组</a>
     * <pre>
     * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
     *
     * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
     *
     * 如果不存在这样的子数组，请返回 0 。
     *
     * 1 <= nums.length <= 10^5
     * nums[i] 要么是 0 要么是 1 。</pre>
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        int res = 0;
        int l = 0;
        int cnt = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                cnt++;
            }
            while (cnt > 1) {
                if (nums[l++] == 0) {
                    cnt--;
                }
            }
            res = Math.max(res, r - l + 1);
        }
        return res - 1;
    }
}
