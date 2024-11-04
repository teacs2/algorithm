package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，
 * 其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class LC92b {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode curr = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    /*
    1 2024年10月30日
     */
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head); //头节点变动一般都要准备一个哨兵
        ListNode pre = dummy;       // left前一个节点，指向反转后的部分链表
        for (int i = 0; i < left - 1; i++) pre = pre.next;
        ListNode cur = pre.next;
        // 插入法，将当前cur插入到pre后面
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
