package com.algorithm.boot.leetcode.lc1600_1699;

public class LC1658a {

    /**
     * <a href="https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/">1658. 将 x 减到 0 的最小操作数 中等</a><pre>
     * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
     * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
     *
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^4
     * 1 <= x <= 10^9
     * </pre>
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {
        // 相当于求恰好等于k的最长的滑动窗口和,  k = sum(nums) - x
        int k = -x;
        for (int num : nums) {
            k += num;
        }
        if (k < 0) {
            return -1;
        }
        int res = -1;
        int l = 0;
        int sum = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum > k) {
                sum -= nums[l++];
            }
            if (sum == k) {
                res = Math.max(res, r - l + 1);
            }
        }
        return res == -1 ? -1 : nums.length - res;
    }
}
