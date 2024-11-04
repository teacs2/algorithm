package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 143. 重排链表
 * 中等
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class LC143a {
    /*
    相当于，把链表从中间切成两端，将后半部分链表倒着插入到前面的链表
    0 -> 1 -> 2 -> 3 -> 4 // 5 -> 6 -> 7 -> 8 -> (9)
    0 -> 1 -> 2 -> 3 -> 4
       8    7    6    5   (x)
     */
    public void reorderList(ListNode head) {
        // 1. 找到中心节点
        ListNode midNode = getMidNode(head);
        ListNode temp = midNode;
        midNode = midNode.next;
        temp.next = null;
        // 2. 反转后半部分
        midNode = reverse(midNode);
        // 3.依次插入
        ListNode curr = head;
        ListNode pre = null;
        while (midNode != null) {
            ListNode point = midNode;
            ListNode next = curr.next;
            midNode = midNode.next;

            pre = curr;
            curr = curr.next;
            pre.next = point;
            point.next = next;
        }
    }

    private ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
