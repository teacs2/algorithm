package com.algorithm.boot.leetcode.lc3400_3499;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC3439aTest {

    @Test
    void maxFreeTime1() {
        LC3439a lc3439a = new LC3439a();
        int eventTime = 5;
        int k = 1;
        int[] startTime = {1, 3};
        int[] endTime = {2, 5};
        int expected = 2;
        assertEquals(expected, lc3439a.maxFreeTime(eventTime, k, startTime, endTime));
    }

    @Test
    void maxFreeTime2() {
        LC3439a lc3439a = new LC3439a();
        int eventTime = 10;
        int k = 1;
        int[] startTime = {0, 2, 9};
        int[] endTime = {1, 4, 10};
        int expected = 6;
        assertEquals(expected, lc3439a.maxFreeTime(eventTime, k, startTime, endTime));
    }

    @Test
    void maxFreeTime3() {
        LC3439a lc3439a = new LC3439a();
        int eventTime = 5;
        int k = 2;
        int[] startTime = {0, 1, 2, 3, 4};
        int[] endTime = {1, 2, 3, 4, 5};
        int expected = 0;
        assertEquals(expected, lc3439a.maxFreeTime(eventTime, k, startTime, endTime));
    }
}