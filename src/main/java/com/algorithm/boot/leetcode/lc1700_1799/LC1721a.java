package com.algorithm.boot.leetcode.lc1700_1799;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 1721. 交换链表中的节点
 * 给你链表的头节点 head 和一个整数 k 。
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 */
public class LC1721a {
    /**
     * 交换值
     * @param head
     * @param k
     * @return
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        ListNode cur = head;
        ListNode last = head;
        int cnt = 1;
        while (cur.next != null) {
            if (cnt++ < k) {
                first = first.next;
            } else {
                last = last.next;
            }
            cur = cur.next;
        }
        cnt = first.val;
        first.val = last.val;
        last.val = cnt;
        return head;
    }

    /*
    1 2024年10月30日
     */
    public ListNode swapNodes1(ListNode head, int k) {
        ListNode first = head;
        ListNode last = head;
        ListNode curr = head;
        // 计数
        int cnt = 1;
        // curr != null 会多走一步
        while (curr.next != null) {
            if (cnt++ < k) {
                first = first.next;
            } else {
                last = last.next;
            }
            curr = curr.next;
        }
        cnt = first.val;
        first.val = last.val;
        last.val = cnt;
        return head;
    }

    /*
    2 2024年11月12日
     */
    public ListNode swapNodes2(ListNode head, int k) {
        ListNode first = head;
        ListNode last = head;
        ListNode cur = head;
        int cnt = 1;
        while (cur.next != null) {
            if (cnt++ < k) {
                first = first.next;
            } else {
                last = last.next;
            }
            cur = cur.next;
        }
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
        return head;
    }
}
