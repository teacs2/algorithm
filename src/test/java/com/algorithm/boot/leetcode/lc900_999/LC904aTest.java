package com.algorithm.boot.leetcode.lc900_999;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC904aTest {

    @Test
    void totalFruit1() {
        LC904a lc904a = new LC904a();
        int[] fruits = {1, 2, 1};
        int expected = 3;
        assertEquals(expected, lc904a.totalFruit(fruits));
    }

    @Test
    void totalFruit2() {
        LC904a lc904a = new LC904a();
        int[] fruits = {0, 1, 2, 2};
        int expected = 3;
        assertEquals(expected, lc904a.totalFruit(fruits));
    }

    @Test
    void totalFruit3() {
        LC904a lc904a = new LC904a();
        int[] fruits = {1, 2, 3, 2, 2};
        int expected = 4;
        assertEquals(expected, lc904a.totalFruit(fruits));
    }

    @Test
    void totalFruit4() {
        LC904a lc904a = new LC904a();
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int expected = 5;
        assertEquals(expected, lc904a.totalFruit(fruits));
    }
}