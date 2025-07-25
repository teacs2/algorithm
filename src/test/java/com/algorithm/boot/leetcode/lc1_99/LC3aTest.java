package com.algorithm.boot.leetcode.lc1_99;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC3aTest {

    @Test
    void lengthOfLongestSubstring() {
        LC3a lc3a = new LC3a();
        assertEquals(3, lc3a.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, lc3a.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, lc3a.lengthOfLongestSubstring("pwwkew"));
    }
}