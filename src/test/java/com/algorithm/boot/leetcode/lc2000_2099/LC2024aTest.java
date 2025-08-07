package com.algorithm.boot.leetcode.lc2000_2099;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC2024aTest {

    @Test
    void maxConsecutiveAnswers1() {
        LC2024a lc2024a = new LC2024a();
        String answerKey = "TTFF";
        int k = 2;
        int expected = 4;
        assertEquals(expected, lc2024a.maxConsecutiveAnswers(answerKey, k));
    }

    @Test
    void maxConsecutiveAnswers2() {
        LC2024a lc2024a = new LC2024a();
        String answerKey = "TFFT";
        int k = 1;
        int expected = 3;
        assertEquals(expected, lc2024a.maxConsecutiveAnswers(answerKey, k));
    }

    @Test
    void maxConsecutiveAnswers3() {
        LC2024a lc2024a = new LC2024a();
        String answerKey = "TTFTTFTT";
        int k = 1;
        int expected = 5;
        assertEquals(expected, lc2024a.maxConsecutiveAnswers(answerKey, k));
    }
}