package com.algorithm.boot.leetcode.lc900_999;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC988aTest {
    LC988a lc;
    TreeNode root1;
    TreeNode root2;
    TreeNode root3;
    @BeforeEach
    void setUp() {
        lc = new LC988a();
        root1 = TreeNode.arrayToTreeNode(new Integer[]{0,1,2,3,4,3,4});
        root2 = TreeNode.arrayToTreeNode(new Integer[]{25,1,3,1,3,0,2});
        root3 = TreeNode.arrayToTreeNode(new Integer[]{2,2,1,null,1,0,null,0});
    }

    @Test
    void smallestFromLeaf() {
        assertEquals("dba", lc.smallestFromLeaf(root1));
        assertEquals("adz", lc.smallestFromLeaf(root2));
        assertEquals("abc", lc.smallestFromLeaf(root3));
    }

    @Test
    void smallestFromLeaf1() {
        assertEquals("dba", lc.smallestFromLeaf1(root1));
        assertEquals("adz", lc.smallestFromLeaf1(root2));
        assertEquals("abc", lc.smallestFromLeaf1(root3));
    }

    @Test
    void smallestFromLeaf2() {
        assertEquals("dba", lc.smallestFromLeaf2(root1));
        assertEquals("adz", lc.smallestFromLeaf2(root2));
        assertEquals("abc", lc.smallestFromLeaf2(root3));
    }
}