package com.algorithm.boot.leetcode.lc400_499;

import com.algorithm.boot.datastructure.ListNode;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 445. 两数相加 II
 * 中等
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 */
public class LC445a {
    /**
     * 栈
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }
        int carry = 0;
        ListNode head = null;
        ListNode next = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int n1 = 0, n2 = 0;
            if (!stack1.isEmpty()) n1 = stack1.pop();
            if (!stack2.isEmpty()) n2 = stack2.pop();
            int sum = carry + n1 + n2;
            carry = sum / 10;
            head = new ListNode(sum % 10, next);
            next = head;
        }
        if (carry != 0) {
            head = new ListNode(carry, next);
        }
        return head;
    }

    /*
    2025年3月20日
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        var stack1 = new ArrayDeque<Integer>();
        var stack2 = new ArrayDeque<Integer>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }
        int carry = 0;
        ListNode head = null;
        ListNode next = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int n1 = 0, n2 = 0;
            if (!stack1.isEmpty()) n1 = stack1.pop();
            if (!stack2.isEmpty()) n2 = stack2.pop();
            int sum = carry + n1 + n2;
            carry = sum / 10;
            head = new ListNode(sum % 10, next);
            next = head;
        }
        if (carry != 0) {
            head = new ListNode(carry, next);
        }
        return head;
    }
}
