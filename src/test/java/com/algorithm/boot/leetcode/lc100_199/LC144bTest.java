package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LC144bTest {

    LC144b lc;
    TreeNode root1;
    TreeNode root2;
    @BeforeEach
    void setUp() {
        lc = new LC144b();
        root1 = TreeNode.arrayToTreeNode(new Integer[]{1,null,2,3});
        root2 = TreeNode.arrayToTreeNode(new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9});
    }

    @Test
    void preorderTraversal() {
        assertEquals(Arrays.asList(1,2,3), lc.preorderTraversal(root1));
        assertEquals(Arrays.asList(1,2,4,5,6,7,3,8,9), lc.preorderTraversal(root2));
    }

    @Test
    void preorderTraversal1() {
        assertEquals(Arrays.asList(1,2,3), lc.preorderTraversal1(root1));
        assertEquals(Arrays.asList(1,2,4,5,6,7,3,8,9), lc.preorderTraversal1(root2));
    }

    @Test
    void preorderTraversal2() {
        assertEquals(Arrays.asList(1,2,3), lc.preorderTraversal2(root1));
        assertEquals(Arrays.asList(1,2,4,5,6,7,3,8,9), lc.preorderTraversal2(root2));
    }

    @Test
    void preorderTraversal3() {
        assertEquals(Arrays.asList(1,2,3), lc.preorderTraversal3(root1));
        assertEquals(Arrays.asList(1,2,4,5,6,7,3,8,9), lc.preorderTraversal3(root2));
    }
}