package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC111aTest {
    TreeNode root1;
    TreeNode root2;
    LC111a lc;
    @BeforeEach
    void setUp() {
        root1 = TreeNode.arrayToTreeNode(new Integer[]{3,9,20,null,null,15,7});
        root2 = TreeNode.arrayToTreeNode(new Integer[]{2,null,3,null,4,null,5,null,6});
        lc = new LC111a();
    }

    @Test
    void minDepth() {
        assertEquals(2, lc.minDepth(root1));
        assertEquals(5, lc.minDepth(root2));
    }

    @Test
    void minDepth1() {
        assertEquals(2, lc.minDepth1(root1));
        assertEquals(5, lc.minDepth1(root2));
    }
}