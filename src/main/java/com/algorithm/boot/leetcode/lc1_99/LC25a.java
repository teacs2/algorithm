package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 25. K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class LC25a {
    /**
     * 将链表拆散，每个长度为k，分别将每一段翻转，再拼接起来
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = reverse1Group(head, tail);

            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    private ListNode[] reverse1Group(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode curr = head;
        while (prev != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{tail, head};
    }
}
