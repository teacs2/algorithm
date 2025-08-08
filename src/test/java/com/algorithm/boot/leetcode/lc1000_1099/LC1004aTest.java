package com.algorithm.boot.leetcode.lc1000_1099;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1004aTest {

    @Test
    void longestOnes1() {
        LC1004a lc1004a = new LC1004a();
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int expected = 6;
        assertEquals(expected, lc1004a.longestOnes(nums, k));
    }

    @Test
    void longestOnes2() {
        LC1004a lc1004a = new LC1004a();
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        int expected = 10;
        assertEquals(expected, lc1004a.longestOnes(nums, k));
    }
}