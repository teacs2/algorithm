package com.algorithm.boot.leetcode.lc3200_3299;

import com.algorithm.boot.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3217. 从链表中移除在数组中存在的节点
 * 给你一个整数数组 nums 和一个链表的头节点 head。从链表中移除所有存在于 nums 中的节点后，返回修改后的链表的头节点。
 *
 * 在203的基础上，将数组中的值添加进集合中
 */
public class LC3217a {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) set.add(num);
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;
        while (curr.next != null) {
            if (set.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
