package com.algorithm.boot.leetcode.lc3000_3099;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC3090aTest {

    @Test
    void maximumLengthSubstring() {
        LC3090a lc3090a = new LC3090a();
        assertEquals(4, lc3090a.maximumLengthSubstring("bcbbbcba"));
        assertEquals(2, lc3090a.maximumLengthSubstring("aaaa"));
    }
}