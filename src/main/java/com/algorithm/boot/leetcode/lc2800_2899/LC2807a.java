package com.algorithm.boot.leetcode.lc2800_2899;

import com.algorithm.boot.datastructure.ListNode;

public class LC2807a {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode node = head;
        while (node.next != null) {
            node.next = new ListNode(gcd(node.val, node.next.val), node.next);
            node = node.next.next;
        }
        return head;
    }

    private int gcd(int num1, int num2) {
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }
}
