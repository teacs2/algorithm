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
public class LC382b {
    ListNode head;
    Random random;


    public LC382b(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /**
     * 进阶: 不知道链表长度,且链表长度非常大
     * 水塘抽样
     * 假如抽中第i个元素,则命中概率有
     *  p = 1/i * (1 - 1/(i+1)) * (1 - 1/(i+2)) ... * (1 - 1/n)
     *    = 1/i * i/(i+1) ... (n-1)/n
     *    = 1/n
     * @return
     */
    public int getRandom() {
        int i = 1;
        int ans = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (random.nextInt(i) == 0) {
                ans = cur.val;
            }
            i++;
        }
        return ans;
    }
}
