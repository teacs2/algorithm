package com.algorithm.boot.leetcode.lc900_999;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC994aTest {
    LC994a lc994a;
    int[][] input;
    int expected;

    @BeforeEach
    void setUp() {
        lc994a = new LC994a();
    }

    @DisplayName("一个坏橘子")
    @Test
    void orangesRotting_test_1() {
        input = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        expected = 4;
        assertEquals(expected, lc994a.orangesRotting(input));
    }

    @DisplayName("隔离好橘子")
    @Test
    void orangesRotting_test_2() {
        input = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        expected = -1;
        assertEquals(expected, lc994a.orangesRotting(input));
    }

    @DisplayName("没有坏橘子")
    @Test
    void orangesRotting_test_3() {
        input = new int[][]{{0, 2}};
        expected = 0;
        assertEquals(expected, lc994a.orangesRotting(input));
    }
}