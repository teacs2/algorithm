package com.algorithm.boot.leetcode.lc2800_2899;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LC2841aTest {

    @Test
    void maxSum1() {
        LC2841a lc2841a = new LC2841a();
        List<Integer> nums = Arrays.asList(2, 6, 7, 3, 1, 7);
        int m = 3;
        int k = 4;
        long target = 18;
        assertEquals(target, lc2841a.maxSum(nums, m, k));
    }

    @Test
    void maxSum2() {
        LC2841a lc2841a = new LC2841a();
        List<Integer> nums = Arrays.asList(5, 9, 9, 2, 4, 5, 4);
        int m = 1;
        int k = 3;
        long target = 23;
        assertEquals(target, lc2841a.maxSum(nums, m, k));
    }

    @Test
    void maxSum3() {
        LC2841a lc2841a = new LC2841a();
        List<Integer> nums = Arrays.asList(1, 2, 1, 2, 1, 2, 1);
        int m = 3;
        int k = 3;
        long target = 0;
        assertEquals(target, lc2841a.maxSum(nums, m, k));
    }
}