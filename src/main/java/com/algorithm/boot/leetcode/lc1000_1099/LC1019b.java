package com.algorithm.boot.leetcode.lc1000_1099;

import com.algorithm.boot.datastructure.ListNode;

import java.util.ArrayDeque;

/**
 * 1019. 链表中的下一个更大节点
 * 中等
 * 给定一个长度为 n 的链表 head
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。
 * 如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。
 */
public class LC1019b {

    private int n;

    /**
     * 单调栈，从右往左遍历
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        head = reverseList(head);
        var ans = new int[n];
        var st = new ArrayDeque<Integer>(); // 单调栈（节点值）
        for (var cur = head; cur != null; cur = cur.next) {
            while (!st.isEmpty() && cur.val >= st.peek()) st.pop();
            ans[--n] = st.isEmpty() ? 0 : st.peek();
            st.push(cur.val);
        }
        return ans;
    }

    // 206. 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            n++;    // 记录链表长度
        }
        return pre;
    }
}
