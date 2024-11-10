package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 148. 排序链表
 * 中等
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class LC148a {
    /**
     * 归并排序，自顶向下（递归实现）
     * 找到中间节点，将链表分为两个，一直分直到只有一个或者为空，合并子链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 切断为两个链表
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        // 21.合并两个有序链表
        return mergeTwoLists(left,right);
    }

    /*
    2024年11月10日
     */
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        // fast = head的话,当链表长度为2时,slow会指向第二个节点,而此时 slow.next本身就是null
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList1(head);
        ListNode right = sortList1(tmp);

        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (list1 != null && list2 !=null) {
            if (list1.val > list2.val) {
                pre.next = list2;
                list2 = list2.next;
            } else {
                pre.next = list1;
                list1 = list1.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
