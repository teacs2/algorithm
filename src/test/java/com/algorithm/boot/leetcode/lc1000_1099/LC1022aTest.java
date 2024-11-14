package com.algorithm.boot.leetcode.lc1000_1099;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1022aTest {

    LC1022a lc;
    TreeNode root1;
    TreeNode root2;
    @BeforeEach
    void setUp() {
        lc = new LC1022a();
        root1 = TreeNode.arrayToTreeNode(new Integer[]{1,0,1,0,1,0,1});
        root2 = TreeNode.arrayToTreeNode(new Integer[]{0});
    }

    @Test
    void sumRootToLeaf() {
        assertEquals(22, lc.sumRootToLeaf(root1));
        assertEquals(0, lc.sumRootToLeaf(root2));
    }
}