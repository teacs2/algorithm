package com.algorithm.boot.leetcode.lc1200_1299;

/**
 * 1206. 设计跳表
 * 困难   参考: https://leetcode.cn/problems/design-skiplist/solutions/1698640/she-ji-tiao-biao-by-capital-worker-3vqk/
 */
public class SkipList {
    class Node {
        int val;
        Node[] next;
        Node (int val, int maxLevel){
            next = new Node[maxLevel];
        }
    }

    private static final int MAX_LEVEL = 32;
    private static final double SKIPLIST_P = 0.25;
    private  Node head;
    private int curLevel;


    public void Skiplist() {
        this.head = new Node(0, MAX_LEVEL);
        curLevel = 0;
    }

    public boolean search(int target) {
        return false;
    }

    public void add(int num) {

    }

    public boolean erase(int num) {

        return false;
    }
}
