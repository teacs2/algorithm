package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC129aTest {

    TreeNode root1;
    TreeNode root2;
    LC129a lc;

    @BeforeEach
    void setUp() {
        lc = new LC129a();
        root1 = TreeNode.arrayToTreeNode(new Integer[]{1, 2, 3});
        root2 = TreeNode.arrayToTreeNode(new Integer[]{4, 9, 0, 5, 1});
    }

    @Test
    void sumNumbers() {
        assertEquals(25, lc.sumNumbers(root1));
        assertEquals(1026, lc.sumNumbers(root2));
    }

    @Test
    void sumNumbers2() {
        assertEquals(25, lc.sumNumbers2(root1));
        assertEquals(1026, lc.sumNumbers2(root2));
    }
}