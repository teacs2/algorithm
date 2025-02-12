package com.algorithm.boot.leetcode.lc700_799;

import com.algorithm.boot.datastructure.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC725aTest {

    LC725a lc;

    ListNode head1;
    ListNode head2;

    @BeforeEach
    void setUp() {
        lc = new LC725a();
        head1 = ListNode.buildFromArray(new Integer[]{1,2,3});
        head2 = ListNode.buildFromArray(new Integer[]{1,2,3,4,5,6,7,8,9,10});
    }
    @Test
    void splitListToParts() {
        assertArrayEquals(new ListNode[]{new ListNode(1), new ListNode(2), new ListNode(3), null, null},
                lc.splitListToParts(head1, 5));
        assertArrayEquals(new ListNode[]{
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))),
                new ListNode(5, new ListNode(6, new ListNode(7))),
                new ListNode(8, new ListNode(9, new ListNode(10)))},
                lc.splitListToParts(head2, 3));
    }

    @Test
    void splitListToParts1() {
        assertArrayEquals(new ListNode[]{new ListNode(1), new ListNode(2), new ListNode(3), null, null},
                lc.splitListToParts1(head1, 5));
        assertArrayEquals(new ListNode[]{
                        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))),
                        new ListNode(5, new ListNode(6, new ListNode(7))),
                        new ListNode(8, new ListNode(9, new ListNode(10)))},
                lc.splitListToParts1(head2, 3));
    }
}