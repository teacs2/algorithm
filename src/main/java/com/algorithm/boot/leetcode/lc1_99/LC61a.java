package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 61. 旋转链表
 * 中等
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class LC61a {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int offset = n - k % n;
        if (offset == n) return head;
        iter.next = head;
        while (offset-- > 0) {
            iter = iter.next;
        }
        head = iter.next;
        iter.next = null;
        return head;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        // k % n表示向前移动k位置， n - k % n表示向后移动k个位置
        int offset = n - k % n;
        if (offset == n) return head;
        iter.next = head;
        while (offset-- > 0) {
            iter = iter.next;
        }
        head = iter.next;
        iter.next = null;
        return head;
    }

    /*
    2 2024年11月12日
     */
    public ListNode rotateRight2(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) { // 获取链表长度
            iter = iter.next;
            n++;
        }
        int offset = n - k % n; // 遍历链表相当于是往左移动链表，往右的话 就是 n - k % n
        if (offset == 0) return head;
        iter.next = head;
        while (offset-- > 0) {
            iter = iter.next;
        }
        head = iter.next;
        iter.next = null;
        return head;
    }

    /*
    2025年2月18日
     */
    public ListNode rotateRight3(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int offset = n - k % n;
        if (offset == 0) return head;
        iter.next = head;
        while (offset-- > 0) {
            iter = iter.next;
        }
        head = iter.next;
        iter.next = null;
        return head;
    }
}