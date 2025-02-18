package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC112aTest {
    TreeNode root1;
    TreeNode root2;
    LC112a lc;

    @BeforeEach
    void setUp() {
        root1 = TreeNode.arrayToTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        root2 = TreeNode.arrayToTreeNode(new Integer[]{1, 2, 3});
        lc = new LC112a();
    }

    @Test
    void hasPathSum() {
        assertEquals(true, lc.hasPathSum(root1, 22));
        assertEquals(false, lc.hasPathSum(root2, 5));
    }

    @Test
    void hasPathSum1() {
        assertEquals(true, lc.hasPathSum1(root1, 22));
        assertEquals(false, lc.hasPathSum1(root2, 5));
    }

    @Test
    void hasPathSum2() {
        assertEquals(true, lc.hasPathSum2(root1, 22));
        assertEquals(false, lc.hasPathSum2(root2, 5));
    }
}