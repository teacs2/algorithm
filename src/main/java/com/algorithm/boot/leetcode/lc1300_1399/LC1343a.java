package com.algorithm.boot.leetcode.lc1300_1399;

/**
 *<a href="https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/">
 *     1343. 大小为 K 且平均值大于等于阈值的子数组数目</a>
 *     给你一个整数数组 arr 和两个整数 k 和 threshold 。
 *     请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 */
public class LC1343a {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i < k - 1) {
                continue;
            }
            if (sum / k >= threshold) {
                res++;
            }
            sum -= arr[i - k + 1];
        }
        return res;
    }
}
