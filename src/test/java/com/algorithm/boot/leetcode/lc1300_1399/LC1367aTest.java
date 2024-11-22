package com.algorithm.boot.leetcode.lc1300_1399;

import com.algorithm.boot.datastructure.ListNode;
import com.algorithm.boot.datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1367aTest {
    LC1367a lc;
    ListNode head1;
    TreeNode root1;
    ListNode head2;
    TreeNode root2;
    ListNode head3;
    TreeNode root3;
    ListNode head4;
    TreeNode root4;

    @BeforeEach
    void setUp() {
        lc = new LC1367a();
        head1 = ListNode.buildFromArray(new Integer[]{4, 2, 8});
        root1 = TreeNode.arrayToTreeNode(new Integer[]{1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3});
        head2 = ListNode.buildFromArray(new Integer[]{1, 4, 2, 6});
        root2 = TreeNode.arrayToTreeNode(new Integer[]{1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3});
        head3 = ListNode.buildFromArray(new Integer[]{1, 4, 2, 6, 8});
        root3 = TreeNode.arrayToTreeNode(new Integer[]{1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3});
        head4 = ListNode.buildFromArray(new Integer[]{1, 10});
        root4 = TreeNode.arrayToTreeNode(new Integer[]{1,null,1,10,1,9});
    }

    @Test
    void isSubPath() {
        assertTrue(lc.isSubPath(head1,root1));
        assertTrue(lc.isSubPath(head2,root2));
        assertFalse(lc.isSubPath(head3, root3));
        assertTrue(lc.isSubPath(head4, root4));
    }
}