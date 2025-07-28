package com.algorithm.boot.leetcode.lc1600_1699;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1695aTest {

    @Test
    void maximumUniqueSubarray1() {
        LC1695a lc1695a = new LC1695a();
        int[] nums = {4, 2, 4, 5, 6};
        int expected = 17;
        assertEquals(expected, lc1695a.maximumUniqueSubarray(nums));
    }

    @Test
    void maximumUniqueSubarray2() {
        LC1695a lc1695a = new LC1695a();
        int[] nums = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        int expected = 8;
        assertEquals(expected, lc1695a.maximumUniqueSubarray(nums));
    }
}