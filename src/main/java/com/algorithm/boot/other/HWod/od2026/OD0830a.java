package com.algorithm.boot.other.HWod.od2026;

/**
 * # 小花获胜的奶茶
 * <p>
 * ## 题目描述
 * <p>
 * 小菊和小花是好朋友，他们经常一起玩游戏。这天他们玩一个数字游戏，获胜可以获得对方 1 杯奶茶。
 * <p>
 * 游戏规则：
 * <p>
 * 小菊在纸上写了一排数组，小花需要从中选择连续 `k` 个数字，使得这 `k` 个数字的和最大。
 * <p>
 * 小花正确找到最大的值就是获胜，小菊则提供 1 杯奶茶；小花想获胜喝奶茶，请你帮助她。
 * <p>
 * ---
 * <p>
 * ## 输入描述
 * <p>
 * 参数1：给出的一排数字
 * <p>
 * 参数2：`k`
 * <p>
 * ### 约束
 * <p>
 * - `-2147483648 <= 单个数字 <= 21474836472`
 * - `0 < 一排数字长度 < 1063`
 * - 需小花选择连续的数字个数 `k`，`1 <= k <= 小菊给出的一排数字的长度`
 * <p>
 * ---
 * <p>
 * ## 输出描述
 * <p>
 * 返回连续 `k` 个数字的最大和。
 * <p>
 * ---
 * <p>
 * ## 示例1
 * <p>
 * ### 输入
 * <p>
 * ```text
 * 1,3,8,6,4,10
 * 3
 * 输出
 * 20
 * 说明
 * [1,3,8,6,4,10] 小菊给出的一排数字，数字为整数。
 * <p>
 * 3 为连续的数字个数 k。
 * <p>
 * 连续的三个数中，6、4、10 三个数和最大：
 * <p>
 * 6 + 4 + 10 = 20
 */
public class OD0830a {

    /**
     * 返回连续 k 个数字的最大和。
     *
     * @param nums 数字数组
     * @param k    连续选择的元素个数
     * @return 连续 k 个元素的最大和
     */
    public long maxSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums不能为空");
        }

        if (k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("k必须满足 1 <= k <= nums.length");
        }
        long window = 0L;
        for (int i = 0; i < k; i++) {
            window += nums[i];
        }
        long max = window;
        for (int i = k; i < nums.length; i++) {
            window -= nums[i - k];
            window += nums[i];
            max = Math.max(max, window);
        }
        return max;
    }
}
