package com.algorithm.boot.leetcode.lc1000_1099;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1026aTest {

    LC1026a lc;
    TreeNode root1;
    TreeNode root2;

    @BeforeEach
    void setUp() {
        lc = new LC1026a();
        root1 = TreeNode.arrayToTreeNode(new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13});
        root2 = TreeNode.arrayToTreeNode(new Integer[]{1, null, 2, null, 0, 3});
    }

    @Test
    void maxAncestorDiff() {
        assertEquals(7, lc.maxAncestorDiff(root1));
        assertEquals(3, lc.maxAncestorDiff(root2));
    }
}