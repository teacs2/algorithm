package com.algorithm.boot.leetcode.lc1300_1399;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1372aTest {
    LC1372a lc;
    TreeNode root1;
    TreeNode root2;
    TreeNode root3;
    @BeforeEach
    void setUp() {
        lc = new LC1372a();
        root1 = TreeNode.arrayToTreeNode(new Integer[]{1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1});
        root2 = TreeNode.arrayToTreeNode(new Integer[]{1,1,1,null,1,null,null,1,1,null,1});
        root3 = TreeNode.arrayToTreeNode(new Integer[]{1});
    }

    @Test
    void longestZigZag() {
        assertEquals(3, lc.longestZigZag(root1));
        assertEquals(4, lc.longestZigZag(root2));
        assertEquals(0, lc.longestZigZag(root3));
    }
}