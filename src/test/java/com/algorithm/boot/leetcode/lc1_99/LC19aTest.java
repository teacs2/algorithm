package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC19aTest {

    LC19a lc;
    ListNode head1;
    ListNode res1;
    ListNode head2;
    ListNode res2;
    @BeforeEach
    void setUp() {
        lc = new LC19a();
        head1 = ListNode.buildFromArray(new Integer[]{1,2,3,4,5});
        res1 = ListNode.buildFromArray(new Integer[]{1,2,3,5});
        head2 = ListNode.buildFromArray(new Integer[]{1});
        res2 = ListNode.buildFromArray(new Integer[]{});

    }

    @Test
    void removeNthFromEnd() {
        assertEquals(res1, lc.removeNthFromEnd(head1, 2));
        assertEquals(res2, lc.removeNthFromEnd(head2, 1));
    }

    @Test
    void removeNthFromEnd1() {
        assertEquals(res1, lc.removeNthFromEnd1(head1, 2));
        assertEquals(res2, lc.removeNthFromEnd1(head2, 1));
    }

    @Test
    void removeNthFromEnd2() {
        assertEquals(res1, lc.removeNthFromEnd2(head1, 2));
        assertEquals(res2, lc.removeNthFromEnd2(head2, 1));
    }
}