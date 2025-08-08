package com.algorithm.boot.leetcode.lc1600_1699;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1658aTest {

    @Test
    void minOperations1() {
        LC1658a lc1658a = new LC1658a();
        int[] nums = {1,1,4,2,3};
        int x = 5;
        int expected = 2;
        assertEquals(expected, lc1658a.minOperations(nums, x));
    }

    @Test
    void minOperations2() {
        LC1658a lc1658a = new LC1658a();
        int[] nums = {5,6,7,8,9};
        int x = 4;
        int expected = -1;
        assertEquals(expected, lc1658a.minOperations(nums, x));
    }

    @Test
    void minOperations3() {
        LC1658a lc1658a = new LC1658a();
        int[] nums = {3,2,20,1,1,3};
        int x = 10;
        int expected = 5;
        assertEquals(expected, lc1658a.minOperations(nums, x));
    }
}