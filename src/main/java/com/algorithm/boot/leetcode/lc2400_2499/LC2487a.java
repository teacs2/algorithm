package com.algorithm.boot.leetcode.lc2400_2499;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 2487. 从链表中移除节点
 * 给你一个链表的头节点 head 。
 * 移除每个右侧有一个更大数值的节点。
 * 返回修改后链表的头节点 head 。
 */
public class LC2487a {
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = removeNodes(head.next);
        if (node != null && head.val < node.val) {
            return node;
        }
        head.next = node;
        return head;
    }
}
