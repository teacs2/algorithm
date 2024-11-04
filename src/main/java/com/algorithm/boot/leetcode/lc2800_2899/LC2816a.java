package com.algorithm.boot.leetcode.lc2800_2899;

import com.algorithm.boot.datastructure.ListNode;

import java.util.Stack;

/**
 * 2816. 翻倍以链表形式表示的数字
 * 中等
 * 给你一个 非空 链表的头节点 head ，表示一个不含前导零的非负数整数。
 * 将链表 翻倍 后，返回头节点 head 。
 */
public class LC2816a {
    /**
     * 栈
     * @param head
     * @return
     */
    public ListNode doubleIt(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int carry = 0;
        ListNode next = null;
        ListNode curr = null;
        while (!stack.isEmpty()) {
            int n = stack.pop() * 2 + carry;
            curr = new ListNode(n % 10, next);
            next = curr;
            carry = n / 10;
        }
        if (carry > 0) {
            curr = new ListNode(carry, next);
        }
        return curr;
    }
}
