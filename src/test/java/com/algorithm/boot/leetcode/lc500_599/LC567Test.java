package com.algorithm.boot.leetcode.lc500_599;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LC567Test {

    @ParameterizedTest(name = "s1={0}, s2={1} => {2}")
    @CsvSource({
            "'ab', 'eidbaooo', true",
            "'ab', 'eidboaoo', false"
    })
    @DisplayName("字符串的排列")
    void checkInclusion(String s1, String s2, boolean expected) {
        LC567 lc567 = new LC567();
        assertEquals(expected, lc567.checkInclusion(s1, s2));
    }
}