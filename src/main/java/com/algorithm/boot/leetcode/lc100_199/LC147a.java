package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.ListNode;

public class LC147a {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode outer = head;
        while (outer.next != null) {
            ListNode inner = dummy;
            while (inner.next != null) {
                if (inner.next == outer.next) {
                    outer = outer.next;
                    break;
                }
                if (outer.next.val < inner.next.val) {
                    ListNode temp = outer.next;
                    outer.next = outer.next.next;
                    temp.next = inner.next;
                    inner.next = temp;
                    break;
                }
                inner = inner.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildFromArray(new Integer[]{4,2,1,3});

        LC147a a = new LC147a();
        head = a.insertionSortList(head);
    }
}
