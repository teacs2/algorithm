package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC98aTest {

    LC98a lc98a;
    TreeNode root;

    @BeforeEach
    void setUp() {
        lc98a = new LC98a();
    }

    @Test
    void isValidBST() {
        root = TreeNode.arrayToTreeNode(new Integer[]{2,1,3});
        assertTrue(lc98a.isValidBST(root));
    }

    @Test
    void isValidBST_output_true() {
        root = TreeNode.arrayToTreeNode(new Integer[]{5,4,6,null,null,3,7});
        assertFalse(lc98a.isValidBST(root));
    }
}