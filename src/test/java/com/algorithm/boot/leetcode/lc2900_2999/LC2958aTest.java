package com.algorithm.boot.leetcode.lc2900_2999;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC2958aTest {

    @Test
    void maxSubarrayLength1() {
        LC2958a lc2958a = new LC2958a();
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2};
        int k = 2;
        int expected = 6;
        assertEquals(expected, lc2958a.maxSubarrayLength(nums, k));
    }

    @Test
    void maxSubarrayLength2() {
        LC2958a lc2958a = new LC2958a();
        int[] nums = {1,2,1,2,1,2,1,2};
        int k = 1;
        int expected = 2;
        assertEquals(expected, lc2958a.maxSubarrayLength(nums, k));
    }
}