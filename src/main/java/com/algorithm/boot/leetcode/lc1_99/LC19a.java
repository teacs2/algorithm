package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */

public class LC19a {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode node = dummy;
        ListNode end = dummy.next;
        while (end != null) {
            end = end.next;
            n--;
            if (n < 0) {        // 应该是 n < 0
                node = node.next;
            }
        }
        node.next = node.next.next;
        return dummy.next;
    }

    /*
    1 2024年11月12日
    删除倒数第n个节点 -双指针
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        var dummy = new ListNode(0, head);
        var node = dummy;
        var end = dummy.next;
        while (end != null) {
            end = end.next;
            n--;
            if (n < 0) node = node.next;
        }
        node.next = node.next.next;
        return dummy.next;
    }

    /*
    2025年2月17日
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode node = dummy;
        ListNode end = dummy.next;
        while (end != null) {
            end = end.next;
            n--;
            if (n < 0) {
                node = node.next;
            }
        }
        node.next = node.next.next;
        return dummy.next;
    }
}
