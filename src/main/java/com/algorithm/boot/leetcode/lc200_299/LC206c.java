package com.algorithm.boot.leetcode.lc200_299;

import com.algorithm.boot.datastructure.ListNode;

public class LC206c {
    /**
     * 递归优化，不使用额外局部或全局变量存储,newHead一直都是尾节点，反转后即为头节点
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head; // 里层节点指向当前节点
        head.next = null;
        return newHead;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        // 因为head.next == null 保证了，head肯定不为空，最里层的head也就是最后一个节点
        ListNode newHead = reverseList1(head.next); // newHead一直是同一个节点
        head.next.next = head;  // 里层节点指向外层节点
        head.next = null;       // 最外层节点指向空
        return newHead;
    }
}
