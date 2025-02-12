package com.algorithm.boot.leetcode.lc800_899;

import com.algorithm.boot.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LC817a {
    public int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) set.add(num);
        while (head != null) {
            if (set.contains(head.val)) {
                while (head != null && set.contains(head.val)) head = head.next;
                ans++;
            } else {
                head = head.next;
            }
        }
        return ans;
    }

    /*
    2025年2月12日
     */
    public int numComponents1(ListNode head, int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>(nums.length);
        for (Integer num : nums) set.add(num);
        while (head != null) {
            if (set.contains(head.val)) {
                while (head != null && set.contains(head.val)) head = head.next;
                res++;
            } else {
                head = head.next;
            }
        }
        return res;
    }
}
