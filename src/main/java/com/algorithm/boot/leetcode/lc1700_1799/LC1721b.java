package com.algorithm.boot.leetcode.lc1700_1799;

import com.algorithm.boot.datastructure.ListNode;

public class LC1721b {
    /**
     * 交换节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode preFirst = dummy;
        ListNode cur = head;
        ListNode preLast = dummy;
        int cnt = 1;
        while (cur.next != null) {
            if (cnt++ < k) {
                preFirst = preFirst.next;
            } else {
                preLast = preLast.next;
            }
            cur = cur.next;
        }
        ListNode first = preFirst.next;
        ListNode last = preLast.next;
        preFirst.next = last;
        preLast.next = first;
        ListNode temp = last.next;
        last.next = first.next;
        first.next = temp;


        return dummy.next;
    }
}
