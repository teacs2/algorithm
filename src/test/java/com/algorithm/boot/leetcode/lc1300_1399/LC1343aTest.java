package com.algorithm.boot.leetcode.lc1300_1399;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1343aTest {

    @Test
    void numsOfSubarrays1() {
        LC1343a lc1343a = new LC1343a();
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;
        int target = 3;
        assertEquals(target, lc1343a.numOfSubarrays(arr, k, threshold));
    }

    @Test
    void numsOfSubarrays2() {
        LC1343a lc1343a = new LC1343a();
        int[] arr = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int k = 3;
        int threshold = 5;
        int target = 6;
        assertEquals(target, lc1343a.numOfSubarrays(arr, k, threshold));
    }
}