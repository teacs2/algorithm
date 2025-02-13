package com.algorithm.boot.leetcode.lc200_299;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class LC203a {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode preHead = new ListNode(-1, head);
        ListNode curr = preHead, next = head;
        while (next != null) {
            if (next.val == val) {
                curr.next = next.next;
                next = next.next;
            } else {
                curr = curr.next;
                next = next.next;
            }
        }
        return preHead.next;
    }

    /*
    2025年2月13日
     */
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) return head;
        ListNode preHead = new ListNode(-1, head);
        ListNode curr = preHead, next = head;
        while (next != null) {
            if (next.val == val) {
                curr.next = next.next;
                next = curr.next;
            } else {
                curr = curr.next;
                next = next.next;
            }
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildFromArray(new Integer[]{1, 2, 6, 3, 4, 5, 6});

        LC203a lc203a = new LC203a();
        lc203a.removeElements(head,6);
    }
}
