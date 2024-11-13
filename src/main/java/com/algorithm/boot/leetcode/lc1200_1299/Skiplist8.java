package com.algorithm.boot.leetcode.lc1200_1299;

import java.util.Arrays;

/**
 * 1206. 设计跳表
 * 困难   参考: <a href="https://leetcode.cn/problems/design-skiplist/solutions/1698640/she-ji-tiao-biao-by-capital-worker-3vqk/"></a>
 * 跳表中可能存在多个相同的值，你的代码需要处理这种情况。
 */
public class Skiplist8 {
    private static class Node {
        int val;
        Node next[];
        Node(int val, int maxLevel) {
            this.val = val;
            next = new Node[maxLevel];
        }
    }

    private static final int MAX_LEVEL = 32;
    private static final double SKIPLIST_P = 0.25;
    private final Node head;
    private int curLevel;

    public Skiplist8() {
        this.head = new Node(0, MAX_LEVEL);
        curLevel = 0;
    }

    public boolean search(int target) {
        Node cur = head;
        for (int i = curLevel - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < target) {
                cur = cur.next[i];
            }
        }
        cur = cur.next[0];
        return cur != null && cur.val == target;
    }

    public void add(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Arrays.fill(update, head);
        Node cur = head;
        // 找到需要插入的位置
        for (int i = curLevel - 1; i >= 0 ; i--) {
            while (cur.next[i] != null && cur.next[i].val < num) {
                cur = cur.next[i];
            }
            update[i] = cur;
        }
        // 生成随机阶层
        int randomLevel = randomLevel();
        this.curLevel = Math.max(randomLevel, curLevel);
        Node newNode = new Node(num, randomLevel);
        // 更新指针
        for (int i = 0; i < randomLevel; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }

    public boolean erase(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node cur = head;
        // 定位到目标元素位置
        for (int i = curLevel - 1; i >= 0 ; i--) {
            while (cur.next[i] != null && cur.next[i].val < num) {
                cur = cur.next[i];
            }
            update[i] = cur;
        }
        cur = cur.next[0];
        // 判断当前元素是否存在
        if (cur.val != num) return false;
        // 删除该元素
        for (int i = 0; i < cur.next.length; i++) {
            if (update[i].next[i] == null) {
                break;
            }
            // 将指针指向后一个
            update[i].next[i] = cur.next[i];
        }
        // 阶层有可能变小,更新层数
        while (curLevel > 1 && head.next[curLevel - 1] == null) {
            curLevel--;
        }
        return true;
    }

    private int randomLevel() {
        int level = 1;
        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }
}
