package com.algorithm.boot.leetcode.lc800_899;

import com.algorithm.boot.datastructure.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC817aTest {
    LC817a lc;
    ListNode head1;
    ListNode head2;
    int[] nums1;
    int[] nums2;

    @BeforeEach
    void setUp() {
        lc = new LC817a();
        head1 = ListNode.buildFromArray(new Integer[]{0,1,2,3});
        nums1 = new int[]{0,1,3};
        head2 = ListNode.buildFromArray(new Integer[]{0,1,2,3,4});
        nums2 = new int[]{0,3,1,4};
    }

    @Test
    void numComponents() {
        assertEquals(2, lc.numComponents(head1, nums1));
        assertEquals(2, lc.numComponents(head2, nums2));
    }

    @Test
    void numComponents1() {
        assertEquals(2, lc.numComponents1(head1, nums1));
        assertEquals(2, lc.numComponents1(head2, nums2));
    }
}