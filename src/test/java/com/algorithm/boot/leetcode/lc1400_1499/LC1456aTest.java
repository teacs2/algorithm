package com.algorithm.boot.leetcode.lc1400_1499;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1456aTest {

    @Test
    void maxVowels1() {
        LC1456a lc1456a = new LC1456a();
        String s = "abciiidef";
        int k = 3;
        int target = 3;
        assertEquals(target, lc1456a.maxVowels(s, k));
    }

    @Test
    void maxVowels2() {
        LC1456a lc1456a = new LC1456a();
        String s = "aeiou";
        int k = 2;
        int target = 2;
        assertEquals(target, lc1456a.maxVowels(s, k));
    }

    @Test
    void maxVowels3() {
        LC1456a lc1456a = new LC1456a();
        String s = "leetcode";
        int k = 2;
        int target = 2;
        assertEquals(target, lc1456a.maxVowels(s, k));
    }
}