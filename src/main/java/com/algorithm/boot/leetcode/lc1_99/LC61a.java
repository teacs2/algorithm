package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.ListNode;

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
}
