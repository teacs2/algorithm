package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 2. 两数相加
 * 中等
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class LC2a {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        ListNode pre = curr;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int num = carry + n1 + n2;
            carry = num / 10;
            curr.val = num % 10;
            curr.next = new ListNode(0);
            pre = curr;
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        curr.val = carry;
        if (carry == 0) pre.next = null;
        return head;
    }
}
