package com.algorithm.boot.leetcode.lc800_899;

import com.algorithm.boot.datastructure.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC876aTest {

    LC876a lc;
    ListNode root1;
    ListNode root2;

    @BeforeEach
    void setUp() {
        lc = new LC876a();
        root1 = ListNode.buildFromArray(new Integer[]{1, 2, 3, 4, 5});
        root2 = ListNode.buildFromArray(new Integer[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    void middleNode() {
        assertEquals(3, lc.middleNode(root1).val);
        assertEquals(4, lc.middleNode(root2).val);
    }

    @Test
    void middleNode1() {
        assertEquals(3, lc.middleNode1(root1).val);
        assertEquals(4, lc.middleNode1(root2).val);
    }
}