package com.algorithm.boot.leetcode.lc900_999;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LC971aTest {

    LC971a lc;
    TreeNode root1;
    int[] voyage1;
    TreeNode root2;
    int[] voyage2;
    TreeNode root3;
    int[] voyage3;
    TreeNode root4;
    int[] voyage4;
    TreeNode root5;
    int[] voyage5;

    @BeforeEach
    void setUp() {
        lc = new LC971a();
        root1 = TreeNode.arrayToTreeNode(new Integer[]{1, 2});
        voyage1 = new int[]{2, 1};
        root2 = TreeNode.arrayToTreeNode(new Integer[]{1, 2, 3});
        voyage2 = new int[]{1, 3, 2};
        root3 = TreeNode.arrayToTreeNode(new Integer[]{1, 2, 3});
        voyage3 = new int[]{1, 2, 3};
        root4 = TreeNode.arrayToTreeNode(new Integer[]{2,1,4,5,null,3});
        voyage4 = new int[]{2,4,3,1,5};
        root5 = TreeNode.arrayToTreeNode(new Integer[]{15,26,40,25,38,29,6,48,1,16,8,18,27,21,19,31,39,46,null,49,45,null,22,34,41,42,null,9,null,2,4,null,null,null,17,null,null,null,null,36,24,null,33,null,30,null,null,23,37,null,null,5,12,null,10,7,null,null,null,13,null,null,null,11,43,null,null,null,null,null,null,50,35,3,32,null,null,null,null,null,null,null,null,null,47,null,28,44,14,null,null,null,null,null,20});
        voyage5 = new int[]{15,40,6,21,9,19,2,12,50,47,35,28,20,5,4,10,32,3,14,44,29,18,34,7,11,43,41,27,42,37,23,26,38,16,45,24,13,36,49,8,22,33,25,1,46,48,31,39,17,30};
    }

    @Test
    void flipMatchVoyage() {
        assertArrayEquals(new Integer[]{-1}, lc.flipMatchVoyage(root1, voyage1).toArray());
        assertArrayEquals(new Integer[]{1}, lc.flipMatchVoyage(root2, voyage2).toArray());
        assertArrayEquals(new Integer[]{}, lc.flipMatchVoyage(root3, voyage3).toArray());
        assertArrayEquals(new Integer[]{2}, lc.flipMatchVoyage(root4, voyage4).toArray());
        assertArrayEquals(new Integer[]{-1}, lc.flipMatchVoyage(root5, voyage5).toArray());
    }
}