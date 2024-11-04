package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class LC82a {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101, head);
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            int val = curr.next.val;
            if (curr.next.next.val == val) {
                /*
                curr,curr.next,curr.next.next分别相当于前中后
                不断让前的指针指向后，也即是不断的跳过中，保证了删除所有中间节点
                 */
                while (curr.next != null && curr.next.val == val) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
