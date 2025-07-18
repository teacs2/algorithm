package com.algorithm.boot.leetcode.lc1600_1699;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1652aTest {

    @Test
    void decrypt1() {
        LC1652a lc1652a = new LC1652a();
        int[] code = {5, 7, 1, 4};
        int k = 3;
        int[] target = {12, 10, 16, 13};
        assertArrayEquals(target, lc1652a.decrypt(code, k));
    }

    @Test
    void decrypt2() {
        LC1652a lc1652a = new LC1652a();
        int[] code = {1, 2, 3, 4};
        int k = 0;
        int[] target = {0, 0, 0, 0};
        assertArrayEquals(target, lc1652a.decrypt(code, k));
    }

    @Test
    void decrypt3() {
        LC1652a lc1652a = new LC1652a();
        int[] code = {2, 4, 9, 3};
        int k = -2;
        int[] target = {12, 5, 6, 13};
        assertArrayEquals(target, lc1652a.decrypt(code, k));
    }
}