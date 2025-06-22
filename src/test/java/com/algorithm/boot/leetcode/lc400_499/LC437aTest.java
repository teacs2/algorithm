package com.algorithm.boot.leetcode.lc400_499;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC437aTest {

    LC437a lc437a;
    TreeNode treeNode1;
    int targetSum1;
    int res1;

    TreeNode treeNode2;
    int targetSum2;
    int res2;
    @BeforeEach
    void setUp() {
        /*用例1*/
        treeNode1 = TreeNode.arrayToTreeNode(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        targetSum1 = 8;
        res1 = 3;

        /*用例2*/
        treeNode2 = TreeNode.arrayToTreeNode(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        targetSum2 = 22;
        res2 = 3;
    }

    @Test
    void pathSum() {
        lc437a = new LC437a();
        assertEquals(res1, lc437a.pathSum(treeNode1, targetSum1));
        lc437a = new LC437a();
        assertEquals(res2, lc437a.pathSum(treeNode2, targetSum2));
    }
}