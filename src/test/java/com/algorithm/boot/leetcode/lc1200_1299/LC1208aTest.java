package com.algorithm.boot.leetcode.lc1200_1299;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1208aTest {

    @Test
    void equalSubstring1() {
        LC1208a lc1208a = new LC1208a();
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        int expected = 3;
        assertEquals(expected, lc1208a.equalSubstring(s, t, maxCost));
    }

    @Test
    void equalSubstring2() {
        LC1208a lc1208a = new LC1208a();
        String s = "abcd";
        String t = "cdef";
        int maxCost = 3;
        int expected = 1;
        assertEquals(expected, lc1208a.equalSubstring(s, t, maxCost));
    }

    @Test
    void equalSubstring3() {
        LC1208a lc1208a = new LC1208a();
        String s = "abcd";
        String t = "acde";
        int maxCost = 0;
        int expected = 1;
        assertEquals(expected, lc1208a.equalSubstring(s, t, maxCost));
    }
}