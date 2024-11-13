package com.algorithm.boot.leetcode.lc2000_2099;

import com.algorithm.boot.datastructure.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC2095aTest {
    LC2095a lc;
    ListNode head1;
    ListNode head2;
    ListNode head3;
    @BeforeEach
    void setUp() {
        lc = new LC2095a();
        head1 = ListNode.buildFromArray(new Integer[]{1,3,4,7,1,2,6});
        head2 = ListNode.buildFromArray(new Integer[]{1,2,3,4});
        head3 = ListNode.buildFromArray(new Integer[]{2,1});
    }

    @Test
    void deleteMiddle() {
        assertArrayEquals(new int[]{1,3,4,1,2,6}, ListNode.listToArray(lc.deleteMiddle(head1)));
        assertArrayEquals(new int[]{1,2,4}, ListNode.listToArray(lc.deleteMiddle(head2)));
        assertArrayEquals(new int[]{2}, ListNode.listToArray(lc.deleteMiddle(head3)));
    }

    @Test
    void deleteMiddle1() {
        assertArrayEquals(new int[]{1,3,4,1,2,6}, ListNode.listToArray(lc.deleteMiddle1(head1)));
        assertArrayEquals(new int[]{1,2,4}, ListNode.listToArray(lc.deleteMiddle1(head2)));
        assertArrayEquals(new int[]{2}, ListNode.listToArray(lc.deleteMiddle1(head3)));
    }
}