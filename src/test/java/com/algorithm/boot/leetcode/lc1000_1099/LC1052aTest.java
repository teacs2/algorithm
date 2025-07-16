package com.algorithm.boot.leetcode.lc1000_1099;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1052aTest {

    @Test
    void maxSatisfied1() {
        LC1052a lc1052a = new LC1052a();
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        int target = 16;
        assertEquals(target, lc1052a.maxSatisfied(customers, grumpy, minutes));
    }

    @Test
    void maxSatisfied2() {
        LC1052a lc1052a = new LC1052a();
        int[] customers = new int[]{1};
        int[] grumpy = new int[]{0};
        int minutes = 1;
        int target = 1;
        assertEquals(target, lc1052a.maxSatisfied(customers, grumpy, minutes));
    }
}