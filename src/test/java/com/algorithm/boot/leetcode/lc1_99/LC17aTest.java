package com.algorithm.boot.leetcode.lc1_99;

import cn.hutool.core.collection.CollectionUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LC17aTest {

    private LC17a lc17a;

    @BeforeEach
    void setUp() {
        lc17a = new LC17a();
    }

    @Test
    void shouldReturnCorrectCombinationsForDigits23() {
        String input = "23";
        List<String> expected = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        List<String> actual = lc17a.letterCombinations(input);
        assertTrue(CollectionUtil.isEqualList(expected, actual));
    }

    @Test
    void shouldReturnEmptyListWhenInputIsEmpty() {
        String input = "";
        List<String> expected = List.of();
        List<String> actual = lc17a.letterCombinations(input);
        assertTrue(CollectionUtil.isEqualList(expected, actual));
    }

    @Test
    void shouldReturnSingleDigitCombinations() {
        String input = "2";
        List<String> expected = List.of("a", "b", "c");
        List<String> actual = lc17a.letterCombinations(input);
        assertTrue(CollectionUtil.isEqualList(expected, actual));
    }
}