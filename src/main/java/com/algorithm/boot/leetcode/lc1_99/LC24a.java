package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 */
public class LC24a {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy.next;
        ListNode pre = dummy;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            curr.next = next.next;
            pre.next = next;
            next.next = curr;

            pre = curr;
            curr = curr.next;
        }
        return dummy.next;
    }

    /*
    1 2024年10月30日
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = pre.next;
        /*
        pre -> cur -> nxt -> lat ==>
        pre -> nxt -> cur -> lat
         */
        while (cur != null && cur.next != null) {
            ListNode nxt = cur.next;
            pre.next = nxt;
            cur.next = nxt.next;
            nxt.next = cur;

            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

}