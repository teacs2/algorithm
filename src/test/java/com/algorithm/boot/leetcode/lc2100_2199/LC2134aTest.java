
package com.algorithm.boot.leetcode.lc2100_2199;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LC2134aTest {

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 1, 1, 0, 0}, 1),
                Arguments.of(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0}, 2),
                Arguments.of(new int[]{1, 1, 0, 0, 1}, 0)
        );
    }

    @ParameterizedTest(name = "nums={0} => {1}")
    @MethodSource("testCases")
    @DisplayName("最少交换次数来组合所有的 1 II")
    void minSwaps(int[] nums, int expected) {
        LC2134a lc2134a = new LC2134a();
        assertEquals(expected, lc2134a.minSwaps(nums));
    }
}