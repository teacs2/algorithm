package com.algorithm.boot.leetcode.lc200_299;

import com.algorithm.boot.datastructure.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC206cTest {

    LC206c lc;
    ListNode head1;
    ListNode head2;
    @BeforeEach
    void setUp() {
        lc = new LC206c();
        head1 = ListNode.buildFromArray(new Integer[]{1,2,3,4,5});
        head2 = ListNode.buildFromArray(new Integer[]{1,2});
    }

    @Test
    void reverseList() {
        assertEquals(ListNode.buildFromArray(new Integer[]{5,4,3,2,1}), lc.reverseList(head1));
        assertEquals(ListNode.buildFromArray(new Integer[]{2,1}), lc.reverseList(head2));
    }

    @Test
    void reverseList1() {
        assertEquals(ListNode.buildFromArray(new Integer[]{5,4,3,2,1}), lc.reverseList1(head1));
        assertEquals(ListNode.buildFromArray(new Integer[]{2,1}), lc.reverseList1(head2));
    }

    @Test
    void reverseList2() {
        assertEquals(ListNode.buildFromArray(new Integer[]{5,4,3,2,1}), lc.reverseList2(head1));
        assertEquals(ListNode.buildFromArray(new Integer[]{2,1}), lc.reverseList2(head2));
    }

    @Test
    void reverseList3() {
        assertEquals(ListNode.buildFromArray(new Integer[]{5,4,3,2,1}), lc.reverseList3(head1));
        assertEquals(ListNode.buildFromArray(new Integer[]{2,1}), lc.reverseList3(head2));
    }
}