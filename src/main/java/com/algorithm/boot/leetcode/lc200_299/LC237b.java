package com.algorithm.boot.leetcode.lc200_299;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 237. 删除链表中的节点
 * 在链表中删除给定节点，且调用方法时，只给出目标节点，不给出头节点
 */
public class LC237b {
    public void deleteNode(ListNode node) {
        // 相较于a遍历整个链表，发现只需要删除目标节点下一个即可
        while (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
