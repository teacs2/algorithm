package com.algorithm.boot.leetcode.lc1400_1499;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1423aTest {

    @Test
    void maxScore1() {
        LC1423a lc1423a = new LC1423a();
        int[] cardPoints = new int[]{1,2,3,4,5,6,1};
        int k = 3;
        int target = 12;
        assertEquals(target, lc1423a.maxScore(cardPoints, k));
    }

    @Test
    void maxScore2() {
        LC1423a lc1423a = new LC1423a();
        int[] cardPoints = new int[]{2,2,2};
        int k = 2;
        int target = 4;
        assertEquals(target, lc1423a.maxScore(cardPoints, k));
    }

    @Test
    void maxScore3() {
        LC1423a lc1423a = new LC1423a();
        int[] cardPoints = new int[]{9,7,7,9,7,7,9};
        int k = 7;
        int target = 55;
        assertEquals(target, lc1423a.maxScore(cardPoints, k));
    }
}