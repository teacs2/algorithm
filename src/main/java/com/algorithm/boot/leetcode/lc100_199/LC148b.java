package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 148. 排序链表
 * 中等
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class LC148b {
    public static void main(String[] args) {
        ListNode head = ListNode.buildFromArray(new Integer[]{4, 2, 1, 3});
        LC148b b = new LC148b();
        ListNode node = b.sortList(head);
    }

    /**
     * 归并排序（自底向上-迭代）
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        // 获取链表长度
        int len = getLength(head);
        ListNode dummy = new ListNode(0, head);
        // 将链表依次拆分成长度为intv = 1,2,4,8...的子链表
        for (int intv = 1; intv < len; intv *= 2) {
            // 每次变换长度时，都初始化到链表头
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            /*
             遍历每个步长的子链表，分别排序
             intv = 1, 1与2, 3与4, 5与6, 7与8
             intv = 2, 1-2与3-4, 5-6与7-8
             intv = 4, 1-4与5-8
             */
            while (cur != null) {
                ListNode h1 = cur;              // 第一部分的头节点
                ListNode h2 = split(h1, intv);  // 第二部分的头节点
                cur = split(h2, intv);          // 第三部分的头节点
                ListNode temp = mergeTwoLists(h1, h2);  // 合并两个有序链表
                pre.next = temp;                // 前置节点指向h1
                while (pre.next != null) {      // 前置节点变为h2尾节点
                    pre = pre.next;
                }
            }
        }
        return dummy.next;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (list1 != null && list2 != null) {
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

    private ListNode split(ListNode h1, int intv) {
        for (int i = 0; i < intv - 1; i++) {
            if (h1 != null) {
                h1 = h1.next;
            }
        }
        if (h1 == null) return h1;
        ListNode h2 = h1.next;
        h1.next = null;
        return h2;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
