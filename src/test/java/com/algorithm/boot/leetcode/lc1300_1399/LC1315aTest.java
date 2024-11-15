package com.algorithm.boot.leetcode.lc1300_1399;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1315aTest {
    LC1315a lc;
    TreeNode root1;
    @BeforeEach
    void setUp() {
        lc = new LC1315a();
        root1 = TreeNode.arrayToTreeNode(new Integer[]{6,7,8,2,7,1,3,9,null,1,4,null,null,null,5});
    }

    @Test
    void sumEvenGrandparent() {
        assertEquals(18, lc.sumEvenGrandparent(root1));
    }

    @Test
    void sumEvenGrandparent1() {
        assertEquals(18, lc.sumEvenGrandparent1(root1));
    }

    @Test
    void sumEvenGrandparent2() {
        assertEquals(18, lc.sumEvenGrandparent2(root1));
    }
}