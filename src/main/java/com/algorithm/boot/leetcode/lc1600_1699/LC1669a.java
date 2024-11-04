package com.algorithm.boot.leetcode.lc1600_1699;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 1669. 合并两个链表
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 */
public class LC1669a {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode start = head, end = head;
        while (list1 != null) {
            if (a-- == 1) {
                start = list1;
            }
            if (b-- == -1) {
                end = list1;
            }
            list1 = list1.next;
        }
        start.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = end;
        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.buildFromArray(new Integer[]{0,1,2,3,4,5,6});
        ListNode list2 = ListNode.buildFromArray(new Integer[]{11, 22, 33, 44});

        LC1669a lc1669a = new LC1669a();
        ListNode node = lc1669a.mergeInBetween(list1, 2, 5, list2);
    }
}
