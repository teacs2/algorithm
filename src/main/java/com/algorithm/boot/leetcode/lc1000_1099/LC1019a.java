package com.algorithm.boot.leetcode.lc1000_1099;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 1019. 链表中的下一个更大节点
 * 中等
 * 给定一个长度为 n 的链表 head
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。
 * 如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。
 */
public class LC1019a {

    /**
     * 暴力双循环，低性能
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        if (head == null || head.next == null) return new int[]{0};
        ListNode cur = head;
        ListNode next = cur.next;
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            while (next != null) {
                if (next.val > cur.val) {
                    ans[i] = next.val;
                    break;
                }
                next = next.next;
            }
            if (cur.next == null) ans[i] = 0;
            cur = cur.next;
            if (cur != null) next = cur.next;
        }
        return ans;
    }
}
