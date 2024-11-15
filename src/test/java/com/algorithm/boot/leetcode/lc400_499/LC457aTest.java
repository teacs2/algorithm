package com.algorithm.boot.leetcode.lc400_499;

import com.algorithm.boot.datastructure.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC457aTest {
    LC457a lc;
    int[] nums1;
    int[] nums2;
    int[] nums3;
    @BeforeEach
    void setUp() {
        lc = new LC457a();
        nums1 = new int[]{2,-1,1,2,2};
        nums2 = new int[]{-1,-2,-3,-4,-5,6};
        nums3 = new int[]{1,-1,5,1,4};
    }

    @Test
    void circularArrayLoop() {
        assertEquals(true, lc.circularArrayLoop(nums1));
        assertEquals(false, lc.circularArrayLoop(nums2));
        assertEquals(true, lc.circularArrayLoop(nums3));
    }

    @Test
    void circularArrayLoop1() {
        assertEquals(true, lc.circularArrayLoop1(nums1));
        assertEquals(false, lc.circularArrayLoop1(nums2));
        assertEquals(true, lc.circularArrayLoop1(nums3));
    }
}