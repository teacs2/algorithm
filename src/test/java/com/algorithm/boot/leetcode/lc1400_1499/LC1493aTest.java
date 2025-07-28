package com.algorithm.boot.leetcode.lc1400_1499;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1493aTest {

    @Test
    void longestSubarray1() {
        LC1493a lc1493a = new LC1493a();
        int[] nums = {1, 1, 0, 1};
        int expected = 3;
        assertEquals(expected, lc1493a.longestSubarray(nums));
    }

    @Test
    void longestSubarray2() {
        LC1493a lc1493a = new LC1493a();
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        int expected = 5;
        assertEquals(expected, lc1493a.longestSubarray(nums));
    }

    @Test
    void longestSubarray3() {
        LC1493a lc1493a = new LC1493a();
        int[] nums = {1, 1, 1};
        int expected = 2;
        assertEquals(expected, lc1493a.longestSubarray(nums));
    }
}