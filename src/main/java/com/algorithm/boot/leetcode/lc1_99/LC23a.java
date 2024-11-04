package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 23. 合并 K 个升序链表
 * 困难
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class LC23a {
    /**
     * 分治
     * 把 lists 一分为二（尽量均分），先合并前一半的链表，再合并后一半的链表，然后把这两个链表合并成最终的链表。
     * 如何合并前一半的链表呢？我们可以继续一分为二。如此分下去直到只有一个链表，此时无需合并。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists,0,lists.length);
    }

    private ListNode mergeKLists(ListNode[] lists, int i, int j) {
        int m = j - i;
        if (m == 0) return null;
        if (m == 1) return lists[i];
        ListNode left = mergeKLists(lists, i, (j + i) / 2);
        ListNode right = mergeKLists(lists, (j + i) / 2, j);

        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
