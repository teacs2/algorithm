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

    public static void main(String[] args) {
        ListNode head = ListNode.buildFromArray(new Integer[]{1, 2, 2, 2, 1});

        LC234a a = new LC234a();
        a.isPalindrome(head);
    }
}
