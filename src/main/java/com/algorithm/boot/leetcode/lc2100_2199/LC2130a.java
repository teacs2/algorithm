package com.algorithm.boot.leetcode.lc2100_2199;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 2130. 链表最大孪生和
 * 中等
 * 在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，
 * 第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。
 *
 * 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。
 * 孪生和 定义为一个节点和它孪生节点两者值之和。
 *
 * 给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。
 *
 * 链表的节点数目是 [2, 105] 中的偶数 。
 */
public class LC2130a {
    public int pairSum(ListNode head) {
        // 1. 找到链表中点
        ListNode midNode = getMidNode(head);
        // 2. 反转后半部分链表
        midNode = reverse(midNode);
        // 3. 比较更新最大值
        int ans = 0;
        while (midNode != null) {
            ans = Math.max(ans, midNode.val + head.val);
            midNode = midNode.next;
            head = head.next;
        }
        return ans;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        // 奇数个节点返回slow，偶数返回第二个中心节点slow.next
        if (quick.next == null) return slow;
        else return slow.next;
    }
}
