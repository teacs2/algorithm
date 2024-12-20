package com.algorithm.boot.leetcode.lc1200_1299;

import java.util.Arrays;

/**
 * 1206. 设计跳表
 * 困难   参考: <a href="https://leetcode.cn/problems/design-skiplist/solutions/1698640/she-ji-tiao-biao-by-capital-worker-3vqk/"></a>
 * 跳表中可能存在多个相同的值，你的代码需要处理这种情况。
 */
public class Skiplist {
    private static class Node {
        int val;
        Node[] next;
        Node (int val, int maxLevel){
            this.val = val;
            this.next = new Node[maxLevel];
        }
    }

    private static final int MAX_LEVEL = 32;
    private static final double SKIPLIST_P = 0.25;
    private final Node head;
    private int curLevel;


    public Skiplist() {
        this.head = new Node(0, MAX_LEVEL);
        curLevel = 0;
    }

    public boolean search(int target) {
        Node cur = this.head;
        for (int i = curLevel - 1; i >= 0; i--) {   // 因为第一层是head[0],所以要 -1
            while (cur.next[i] != null && cur.next[i].val < target) {
                cur = cur.next[i];
            }
        }
        cur = cur.next[0];
        return cur != null && cur.val == target;
    }

    public void add(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Arrays.fill(update, head);      // 没有这行,update[i].next[i]可能会有空指针
        Node cur = this.head;
        // 找到需要插入的位置
        for (int i = curLevel - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < num) {
                cur = cur.next[i];
            }
            update[i] = cur;
        }
        //if (cur.next[0] != null && cur.next[0].val == num) return;       // 该题允许有多个相同的num存在
        int randomLevel = randomLevel();
        this.curLevel = Math.max(randomLevel, this.curLevel);
        Node newNode = new Node(num, randomLevel);
        // 更新level对应的节点
        for (int i = 0; i < randomLevel; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }

    public boolean erase(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node cur = this.head;
        for (int i = curLevel - 1; i >= 0; i--) {
            //找到第i层最大的小于target的元素
            while (cur.next[i] != null && cur.next[i].val < num) {
                cur = cur.next[i];
            }
            update[i] = cur;
        }
        cur = cur.next[0];
        //判断num是否存在
        if (cur == null || cur.val != num) {
            return false;
        }
        for (int i = 0; i < curLevel; i++) {
            if (update[i].next[i] != cur) {
                break;
            }
            //删除第i层的值和num相等的元素
            update[i].next[i] = cur.next[i];    // 不会有空指针,因为先定了curLevel
        }
        //有可能最上层只有一个元素，缩短层数
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
