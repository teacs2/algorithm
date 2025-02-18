package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC61aTest {

    LC61a lc;
    ListNode head1;
    ListNode res1;
    ListNode head2;
    ListNode res2;

    @BeforeEach
    void setUp() {
        lc = new LC61a();
        head1 = ListNode.buildFromArray(new Integer[]{1, 2, 3, 4, 5});
        res1 = ListNode.buildFromArray(new Integer[]{4, 5, 1, 2, 3});
        head2 = ListNode.buildFromArray(new Integer[]{0, 1, 2});
        res2 = ListNode.buildFromArray(new Integer[]{2, 0, 1});
    }

    @Test
    void rotateRight() {
        assertEquals(res1, lc.rotateRight(head1, 2));
        assertEquals(res2, lc.rotateRight(head2, 4));
    }

    @Test
    void rotateRight1() {
        assertEquals(res1, lc.rotateRight1(head1, 2));
        assertEquals(res2, lc.rotateRight1(head2, 4));
    }

    @Test
    void rotateRight2() {
        assertEquals(res1, lc.rotateRight2(head1, 2));
        assertEquals(res2, lc.rotateRight2(head2, 4));
    }

    @Test
    void rotateRight3() {
        assertEquals(res1, lc.rotateRight3(head1, 2));
        assertEquals(res2, lc.rotateRight3(head2, 4));
    }
}