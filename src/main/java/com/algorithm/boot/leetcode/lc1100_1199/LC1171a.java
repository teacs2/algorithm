package com.algorithm.boot.leetcode.lc1100_1199;

import com.algorithm.boot.datastructure.ListNode;

import java.util.HashMap;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 * 中等
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * 删除完毕后，请你返回最终结果链表的头节点。
 * 你可以返回任何满足题目要求的答案。
 */
public class LC1171a {
    public static void main(String[] args) {
        var head = ListNode.buildFromArray(new Integer[]{1, 2, -1, -1, -1, 3, 1});
        var a = new LC1171a();
        head = a.removeZeroSumSublists(head);
        for (var cur = head; cur != null; cur = cur.next) {
            System.out.print(" " + cur.val);
        }
    }

    /**
     * 前缀和 + 哈希表
     * 记录每一个前缀和以及对应的节点，当再次遇到相同的前缀和时，表明从上一个相同前缀和到当前节点的链表和为0
     * @param head
     * @return
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return head;
        var map = new HashMap<Integer, ListNode>();
        ListNode dummy = new ListNode(0, head);
        map.put(0, dummy);
        int sum = 0;
        for (var cur = head; cur != null; cur = cur.next) {
            sum += cur.val;
            if (map.containsKey(sum)) {
                var pre = map.get(sum);
                var del = pre.next;
                pre.next = cur.next;

                var delSum = sum;
                while (del != cur) {
                    delSum += del.val;
                    map.remove(delSum);
                    del = del.next;
                }
            } else {
                map.put(sum, cur);
            }
        }
        return dummy.next;
    }

    public ListNode removeZeroSumSublists1(ListNode head) {
        if (head == null) return null;
        var map = new HashMap<Integer, ListNode>();
        var sum = 0;
        var dummy = new ListNode(0, head);  // 头节点可能被删除则需要准备dummy
        map.put(0, dummy);  // 用于解决需要删除头节点的情况
        for (var cur = head; cur != null; cur = cur.next) {
            sum += cur.val;
            if (map.containsKey(sum)) {
                // 删除map中的下一个元素,到当前元素,这一段的和为0
                var pre = map.get(sum);
                var del = pre.next;
                pre.next = cur.next;

                // 整理map中的元素
                var delSum = sum;
                while (del != cur) {
                    delSum += del.val;
                    map.remove(delSum);
                    del = del.next;
                }
            } else {
                map.put(sum, cur);
            }
        }
        return dummy.next;
    }
}
