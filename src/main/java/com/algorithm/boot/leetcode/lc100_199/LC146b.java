package com.algorithm.boot.leetcode.lc100_199;

import java.util.HashMap;
import java.util.Map;

public class LC146b {
}

class LRUCache2 {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        // 不存在，返回-1
        if (node == null) return -1;

        // 存在，移动到链表头，返回值
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果key不存在，创建一个新节点
            node = new DLinkedNode(key, value);
            cache.put(key, node);
            addToHead(node);
            size++;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }


    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next = node;
        node.next.pre = node;
    }

    private DLinkedNode removeTail() {
        DLinkedNode delNode = tail.pre;
        removeNode(delNode);
        return delNode;
    }

    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}