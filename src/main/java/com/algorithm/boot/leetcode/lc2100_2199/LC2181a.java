package com.algorithm.boot.leetcode.lc2100_2199;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 2181. 合并零之间的节点
 * 给你一个链表的头节点 head ，该链表包含由 0 分隔开的一连串整数。链表的 开端 和 末尾 的节点都满足 Node.val == 0 。
 *
 * 对于每两个相邻的 0 ，请你将它们之间的所有节点合并成一个节点，其值是所有已合并节点的值之和。然后将所有 0 移除，修改后的链表不应该含有任何 0 。
 *
 *  返回修改后链表的头节点 head 。
 *
 *  提示：
 *
 * 列表中的节点数目在范围 [3, 2 * 105] 内
 * 0 <= Node.val <= 1000
 * 不 存在连续两个 Node.val == 0 的节点
 * 链表的 开端 和 末尾 节点都满足 Node.val == 0
 */
public class LC2181a {
    public ListNode mergeNodes(ListNode head) {
        ListNode node = mergeNode(head);
        while (node.next.next != null) {
            node.next = mergeNode(node);
        }
        return node;
    }

    private ListNode mergeNode(ListNode node) {
        if (node.next.val == 0) return node;
        ListNode head = node;
        node = node.next;
        while (node.val != 0) {
            head.val += node.val;
            node = node.next;
        }
        head.next = node;
        return head;
    }
}
