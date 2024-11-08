package com.algorithm.boot.leetcode.lc300_399;

import com.algorithm.boot.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 382. 链表随机节点
 * 中等
 * 给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
 * 实现 Solution 类：
 * Solution(ListNode head) 使用整数数组初始化对象。
 * int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。
 */
public class LC382a {
    List<Integer> list;
    Random random;
    public LC382a(ListNode head) {
        list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        random = new Random();
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
