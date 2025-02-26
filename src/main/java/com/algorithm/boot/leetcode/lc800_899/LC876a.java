package com.algorithm.boot.leetcode.lc800_899;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 876. 链表的中间结点
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class LC876a {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;

        while (quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        if (quick.next == null) {
            return slow;
        } else {
            return slow.next;
        }
    }

    /*
    1 2024年11月13日
     */
    public ListNode middleNode1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /*
    2025年2月20日
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
