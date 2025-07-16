package com.algorithm.boot.leetcode.lc2400_2499;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC2461aTest {

    @Test
    void maximumSubarraySum1() {
        LC2461a lc2461a = new LC2461a();
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        int target = 15;
        assertEquals(target, lc2461a.maximumSubarraySum(nums, k));
    }

    @Test
    void maximumSubarraySum2() {
        LC2461a lc2461a = new LC2461a();
        int[] nums = {4, 4, 4};
        int k = 3;
        int target = 0;
        assertEquals(target, lc2461a.maximumSubarraySum(nums, k));
    }
}