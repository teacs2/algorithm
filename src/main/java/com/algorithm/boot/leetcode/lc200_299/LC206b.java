package com.algorithm.boot.leetcode.lc200_299;

import com.algorithm.boot.datastructure.ListNode;

public class LC206b {
    /**
     * 递归实现
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode node = recur(head, dummy);
        node.next = null;
        return dummy.next;
    }

    private ListNode recur(ListNode node, ListNode dummy) {
        if (node == null) return dummy;
        ListNode last = recur(node.next, dummy);
        last.next = node;
        return node;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildFromArray(new Integer[]{1, 2, 3, 4, 5});

        LC206b b = new LC206b();
        head = b.reverseList(head);
        System.out.println(head);
    }
}
