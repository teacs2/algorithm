package com.algorithm.boot.leetcode.lc2000_2099;

import com.algorithm.boot.datastructure.ListNode;

/**
 * 2058. 找出临界点之间的最小和最大距离
 * 链表中的 临界点 定义为一个 局部极大值点 或 局部极小值点 。
 * 如果当前节点的值 严格大于 前一个节点和后一个节点，那么这个节点就是一个  局部极大值点 。
 * 如果当前节点的值 严格小于 前一个节点和后一个节点，那么这个节点就是一个  局部极小值点 。
 * 注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 局部极大值点 / 极小值点 。
 * 给你一个链表 head ，返回一个长度为 2 的数组 [minDistance, maxDistance] ，
 * 其中 minDistance 是任意两个不同临界点之间的最小距离，maxDistance 是任意两个不同临界点之间的最大距离。
 * 如果临界点少于两个，则返回 [-1，-1] 。
 */

public class LC2058a {
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode a = head, b = head.next, c = head.next.next;
        if (c == null) return new int[]{-1, -1};
        int index = 1;int first = -1;int last = -1;
        int min = -1, max = -1;
        while (c != null) {
            if ((b.val < c.val && a.val > b.val) || (b.val > c.val && a.val < b.val)) {
                if (first == -1) first = index;
                if (last != -1) {
                    min = min == -1 ? index - last : (Math.min(min, index - last));
                    max = Math.max(max, index - first);
                }
                last = index;
            }
            index++;
            a = b;
            b = c;
            c = c.next;
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        nodesBetweenCriticalPoints(new ListNode(1));
    }
}
