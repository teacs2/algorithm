
package com.algorithm.boot.leetcode.lc3600_3699;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LC3694Test {

    @ParameterizedTest(name = "s={0}, k={1} => {2}")
    @CsvSource({
            "'LUL', 1, 2",
            "'UDLR', 4, 1",
            "'UU', 1, 1"
    })
    @DisplayName("删除子字符串后不同的终点")
    void distinctPoints(String s, int k, int expected) {
        LC3694 lc3694 = new LC3694();
        assertEquals(expected, lc3694.distinctPoints(s, k));
    }
}