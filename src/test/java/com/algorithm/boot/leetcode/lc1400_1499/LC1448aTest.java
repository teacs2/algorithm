package com.algorithm.boot.leetcode.lc1400_1499;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1448aTest {
    LC1448a lc;
    TreeNode root1;
    TreeNode root2;
    TreeNode root3;
    TreeNode root4;
    @BeforeEach
    void setUp() {
        lc = new LC1448a();
        root1 = TreeNode.arrayToTreeNode(new Integer[]{3,1,4,3,null,1,5});
        root2 = TreeNode.arrayToTreeNode(new Integer[]{3,3,null,4,2});
        root3 = TreeNode.arrayToTreeNode(new Integer[]{-1, 5, -2, 4, 4, 2, -2, null, null, -4, null, -2, 3, null, -2, 0, null, -1, null, -3, null, -4, -3, 3, null, null, null, null, null, null, null, 3, -3});
        root4 = TreeNode.arrayToTreeNode(new Integer[]{1});
    }

    @Test
    void goodNodes() {
        assertEquals(4, lc.goodNodes(root1));
        assertEquals(3, lc.goodNodes(root2));
        assertEquals(5, lc.goodNodes(root3));
        assertEquals(1, lc.goodNodes(root4));
    }

    @Test
    void goodNodes1() {
        assertEquals(4, lc.goodNodes1(root1));
        assertEquals(3, lc.goodNodes1(root2));
        assertEquals(5, lc.goodNodes1(root3));
        assertEquals(1, lc.goodNodes1(root4));
    }
}