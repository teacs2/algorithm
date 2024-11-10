package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. 合并 K 个升序链表
 * 困难
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class LC23b {
    /**
     * 小顶堆
     * 将所有链表节点都存入小顶堆中，依次从堆中读出，拼接为链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) heap.offer(head);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (node.next != null) {
                heap.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }

    /*
    2024年11月10日
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));    // 可以防止整形溢出
        for (ListNode head : lists) {
            if (head != null) heap.offer(head);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (node.next != null) {
                heap.offer(node.next);
            }
            cur.next = node;
            cur = node;
        }
        return dummy.next;
    }
}
