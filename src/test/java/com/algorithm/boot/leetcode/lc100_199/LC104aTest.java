package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC104aTest {

    LC104a lc;
    TreeNode root1;
    TreeNode root2;
    @BeforeEach
    void setUp() {
        lc = new LC104a();
        root1 = TreeNode.arrayToTreeNode(new Integer[]{3,9,20,null,null,15,7});
        root2 = TreeNode.arrayToTreeNode(new Integer[]{1,null,2});
    }

    @Test
    void maxDepth() {
        assertEquals(3, lc.maxDepth(root1));
        assertEquals(2, lc.maxDepth(root2));
    }

    @Test
    void maxDepth1() {
        assertEquals(3, lc.maxDepth1(root1));
        assertEquals(2, lc.maxDepth1(root2));
    }

    @Test
    void maxDepth2() {
        assertEquals(3, lc.maxDepth2(root1));
        assertEquals(2, lc.maxDepth2(root2));
    }
}