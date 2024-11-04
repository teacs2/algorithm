package com.algorithm.boot.leetcode.lc2800_2899;

import com.algorithm.boot.datastructure.ListNode;

public class LC2816b {
    /**
     * 数学，*2当前为数只有＞4才可能会进位，也就是说不用先找到链表尾部
     * @param head
     * @return
     */
    public ListNode doubleIt(ListNode head) {
        if(head.val > 4) {
            head = new ListNode(0,head);
        }
        for (ListNode cur = head; cur != null; cur = cur.next) {
            cur.val = cur.val * 2 % 10;
            if (cur.next != null && cur.next.val > 4) {
                cur.val++;
            }
        }
        return head;
    }
}
