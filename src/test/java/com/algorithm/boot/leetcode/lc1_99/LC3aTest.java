package com.algorithm.boot.leetcode.lc1_99;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LC3aTest {

    @ParameterizedTest(name = "s={0} => {1}")
    @CsvSource({
            "'abcabcbb', 3",
            "'bbbbb', 1",
            "'pwwkew', 3"
    })
    @DisplayName("无重复字符的最长子串")
    void lengthOfLongestSubstring(String s, int expected) {
        LC3a lc3a = new LC3a();
        assertEquals(expected, lc3a.lengthOfLongestSubstring(s));
    }
}
