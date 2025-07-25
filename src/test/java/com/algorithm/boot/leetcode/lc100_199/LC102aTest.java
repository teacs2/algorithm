package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LC102aTest {
    LC102a lc;
    TreeNode root1;
    List<List<Integer>> ans1;
    @BeforeEach
    void setUp() {
        lc = new LC102a();
        root1 = TreeNode.arrayToTreeNode(new Integer[]{3,9,20,null,null,15,7});
        ans1 = Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15,7));
    }

    @Test
    void levelOrder() {
        assertEquals(ans1, lc.levelOrder(root1));
    }

    @Test
    void levelOrder1() {
        assertEquals(ans1, lc.levelOrder1(root1));
    }

    @Test
    void levelOrder2() {
        assertEquals(ans1, lc.levelOrder2(root1));
    }

    @Test
    void levelOrder3() {
        assertEquals(ans1, lc.levelOrder3(root1));
    }
}