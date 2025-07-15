package com.algorithm.boot.leetcode.lc2300_2399;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC2379aTest {

    @Test
    void minimumRecolors1() {
        LC2379a lc2379a = new LC2379a();
        String blocks = "WBBWWBBWBW";
        int k = 7;
        int target = 3;
        assertEquals(target, lc2379a.minimumRecolors(blocks, k));
    }

    @Test
    void minimumRecolors2() {
        LC2379a lc2379a = new LC2379a();
        String blocks = "WBWBBBW";
        int k = 2;
        int target = 0;
        assertEquals(target, lc2379a.minimumRecolors(blocks, k));
    }

}