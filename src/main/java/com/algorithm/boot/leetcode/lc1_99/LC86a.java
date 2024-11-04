package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 86. 分隔链表
 * 中等
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class LC86a {
    public ListNode partition(ListNode head, int x) {
        ListNode bigDummy = new ListNode(0);
        ListNode smlDummy = new ListNode(0);
        ListNode big = bigDummy;
        ListNode sml = smlDummy;
        while (head != null) {
            if (head.val < x) {
                sml.next = head;
                sml = sml.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        sml.next = bigDummy.next;
        return smlDummy.next;
    }
}
