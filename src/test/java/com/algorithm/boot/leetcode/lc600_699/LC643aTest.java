package com.algorithm.boot.leetcode.lc600_699;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC643aTest {

    @Test
    void findMaxAverage1() {
        LC643a lc643a = new LC643a();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double target = 12.75;
        assertEquals(target, lc643a.findMaxAverage(nums, k));
    }

    @Test
    void findMaxAverage2() {
        LC643a lc643a = new LC643a();
        int[] nums = {5};
        int k = 1;
        double target = 5.00000;
        assertEquals(target, lc643a.findMaxAverage(nums, k));
    }
}