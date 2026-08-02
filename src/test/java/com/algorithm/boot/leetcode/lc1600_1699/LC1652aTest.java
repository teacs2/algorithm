package com.algorithm.boot.leetcode.lc1600_1699;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LC1652aTest {

    @ParameterizedTest(name = "code={0}, k={1}")
    @MethodSource("testCases")
    @DisplayName("解密消息")
    void decrypt(int[] code, int k, int[] expected) {
        LC1652a lc1652a = new LC1652a();
        assertArrayEquals(expected, lc1652a.decrypt(code, k));
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{5, 7, 1, 4}, 3, new int[]{12, 10, 16, 13}),
                Arguments.of(new int[]{1, 2, 3, 4}, 0, new int[]{0, 0, 0, 0}),
                Arguments.of(new int[]{2, 4, 9, 3}, -2, new int[]{12, 5, 6, 13})
        );
    }
}
