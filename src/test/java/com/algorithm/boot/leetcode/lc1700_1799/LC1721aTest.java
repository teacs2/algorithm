package com.algorithm.boot.leetcode.lc1700_1799;

import com.algorithm.boot.datastructure.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC1721aTest {
    LC1721a lc;
    ListNode head1;
    ListNode res1;
    ListNode head2;
    ListNode res2;
    ListNode head3;
    ListNode res3;

    @BeforeEach
    void setUp() {
        lc = new LC1721a();
        head1 = ListNode.buildFromArray(new Integer[]{1,2,3,4,5});
        res1 = ListNode.buildFromArray(new Integer[]{1,4,3,2,5});
        head2 = ListNode.buildFromArray(new Integer[]{7,9,6,6,7,8,3,0,9,5});
        res2 = ListNode.buildFromArray(new Integer[]{7,9,6,6,8,7,3,0,9,5});
        head3 = ListNode.buildFromArray(new Integer[]{1});
        res3 = ListNode.buildFromArray(new Integer[]{1});
    }

    @Test
    void swapNodes() {
        assertEquals(res1, lc.swapNodes(head1, 2));
        assertEquals(res2, lc.swapNodes(head2, 5));
        assertEquals(res3, lc.swapNodes(head3, 1));
    }

    @Test
    void swapNodes1() {
        assertEquals(res1, lc.swapNodes1(head1, 2));
        assertEquals(res2, lc.swapNodes1(head2, 5));
        assertEquals(res3, lc.swapNodes1(head3, 1));
    }

    @Test
    void swapNodes2() {
        assertEquals(res1, lc.swapNodes2(head1, 2));
        assertEquals(res2, lc.swapNodes2(head2, 5));
        assertEquals(res3, lc.swapNodes2(head3, 1));
    }

    @Test
    void swapNodes3() {
        assertEquals(res1, lc.swapNodes3(head1, 2));
        assertEquals(res2, lc.swapNodes3(head2, 5));
        assertEquals(res3, lc.swapNodes3(head3, 1));
    }
}