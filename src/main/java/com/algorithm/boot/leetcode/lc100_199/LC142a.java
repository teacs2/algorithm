package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * 中等
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class LC142a {
    /**
     * 方法一 哈希表,同LC141a
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) return head;
            head = head.next;
        }
        return null;
    }
}
