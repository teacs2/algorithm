package com.algorithm.boot.leetcode.lc1400_1499;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1457aTest {
    LC1457a lc;
    TreeNode root1;
    TreeNode root2;
    TreeNode root3;
    @BeforeEach
    void setUp() {
        lc = new LC1457a();
        root1 = TreeNode.arrayToTreeNode(new Integer[]{2,3,1,3,1,null,1});
        root2 = TreeNode.arrayToTreeNode(new Integer[]{2,1,1,1,3,null,null,null,null,null,1});
        root3 = TreeNode.arrayToTreeNode(new Integer[]{9});
    }

    @Test
    void pseudoPalindromicPaths() {
        assertEquals(2, lc.pseudoPalindromicPaths(root1));
        assertEquals(1, lc.pseudoPalindromicPaths(root2));
        assertEquals(1, lc.pseudoPalindromicPaths(root3));
    }

    @Test
    void pseudoPalindromicPaths1() {
        assertEquals(2, lc.pseudoPalindromicPaths1(root1));
        assertEquals(1, lc.pseudoPalindromicPaths1(root2));
        assertEquals(1, lc.pseudoPalindromicPaths1(root3));
    }

    @Test
    void pseudoPalindromicPaths2() {
        assertEquals(2, lc.pseudoPalindromicPaths2(root1));
        assertEquals(1, lc.pseudoPalindromicPaths2(root2));
        assertEquals(1, lc.pseudoPalindromicPaths2(root3));
    }
}