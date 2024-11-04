package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，
 * 其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class LC92a {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverseLinkedList(leftNode);

        pre.next = rightNode;
        leftNode.next = curr;
        return dummy.next;
    }

    private void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
    }
}
