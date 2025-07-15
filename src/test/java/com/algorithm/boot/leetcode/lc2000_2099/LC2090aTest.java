package com.algorithm.boot.leetcode.lc2000_2099;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC2090aTest {

    @Test
    void getAverages1() {
        LC2090a lc2099a = new LC2090a();
        int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
        int k = 3;
        int[] target = {-1, -1, -1, 5, 4, 4, -1, -1, -1};
        assertArrayEquals(target, lc2099a.getAverages(nums, k));
    }

    @Test
    void getAverages2() {
        LC2090a lc2099a = new LC2090a();
        int[] nums = {100000};
        int k = 0;
        int[] target = {100000};
        assertArrayEquals(target, lc2099a.getAverages(nums, k));
    }

    @Test
    void getAverages3() {
        LC2090a lc2099a = new LC2090a();
        int[] nums = {8};
        int k = 100000;
        int[] target = {-1};
        assertArrayEquals(target, lc2099a.getAverages(nums, k));
    }

    @Test
    void getAverages40() {
        LC2090a lc2099a = new LC2090a();
        int[] nums = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int k = 1;
        int[] target = {-1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1};
        assertArrayEquals(target, lc2099a.getAverages(nums, k));
    }

}