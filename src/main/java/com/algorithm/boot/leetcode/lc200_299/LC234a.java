package com.algorithm.boot.leetcode.lc200_299;

import com.algorithm.boot.datastructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * 链表中节点数目在范围[1, 10^5] 内
 * 0 <= Node.val <= 9
 */
public class LC234a {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            stack.push(slow);
            slow = slow.next;
        }
        if (quick.next == null) {
            while (!stack.isEmpty()) {
                slow = slow.next;
                int val = stack.pop().val;
                if (val != slow.val) {
                    return false;
                }
            }
            return true;
        } else {
            stack.push(slow);
            while (!stack.isEmpty()) {
                slow = slow.next;
                int val = stack.pop().val;
                if (val != slow.val) {
                    return false;
                }
            }
            return true;
        }
    }

    /*
    1 2024年11月14日
     */
    public boolean isPalindrome1(ListNode head) {
        if (head.next == null) return true;
        var stack = new ArrayDeque<ListNode>();
        var slow = head;    //  1 2 3 4 5 6     4 null
        var fast = head;    //  1 2 3 4 5 6 7   4 7
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        while (slow != null) {
            if (slow.val != stack.pop().val) return false;
            slow = slow.next;
        }
        return true;
    }

    /*
    2025年2月22日
    栈实现
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null) return false;
        var fast = head;
        var slow = head;
        var stack = new ArrayDeque<ListNode>();
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        while (slow != null) {
            if (slow.val != stack.pop().val) return false;
            slow = slow.next;
        }
        return true;
    }
}
