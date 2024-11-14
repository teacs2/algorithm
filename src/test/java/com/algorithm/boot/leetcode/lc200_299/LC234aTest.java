package com.algorithm.boot.leetcode.lc200_299;

import com.algorithm.boot.datastructure.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC234aTest {
    LC234a lc;
    ListNode head1;
    ListNode head2;
    @BeforeEach
    void setUp() {
        lc = new LC234a();
        head1 = ListNode.buildFromArray(new Integer[]{1,2,2,1});
        head2 = ListNode.buildFromArray(new Integer[]{2, 1});
    }

    @Test
    void isPalindrome() {
        assertTrue(lc.isPalindrome(head1));
        assertFalse(lc.isPalindrome(head2));
    }

    @Test
    void isPalindrome1() {
        assertTrue(lc.isPalindrome1(head1));
        assertFalse(lc.isPalindrome1(head2));
    }
}