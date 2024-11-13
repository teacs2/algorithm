package com.algorithm.boot.leetcode.lc2000_2099;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 2095. 删除链表的中间节点  -mid
 * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
 *
 * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
 *
 * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
 * 链表中节点的数目在范围 [1, 10^5] 内
 */
public class LC2095a {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode slow = head;
        ListNode quick = head;

        while (quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            pre = pre.next;
        }
        if (quick.next == null){
            pre.next = slow.next;
        } else {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }

    /*
    1 2024年11月13日
     */
    public ListNode deleteMiddle1(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;  // 该slow节点为待删除节点的前一个节点
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
