package com.algorithm.boot.leetcode.lc200_299;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC200aTest {

    LC200a lc200a;

    @BeforeEach
    void setUp() {
        lc200a = new LC200a();
    }

    @Test
    void numIslands_1_land() {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int res = 1;
        assertEquals(res, lc200a.numIslands(grid));
    }

    @Test
    void numIslands_3_land() {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int res = 3;
        assertEquals(res, lc200a.numIslands(grid));
    }
}