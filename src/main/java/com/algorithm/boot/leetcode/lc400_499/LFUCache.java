package com.algorithm.boot.leetcode.lc400_499;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU 缓存
 * 困难
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * <p>
 * 实现 LFUCache 类：
 * LFUCache(int capacity)
 * - 用数据结构的容量 capacity 初始化对象
 * int get(int key)
 * - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * void put(int key, int value)
 * - 如果键 key 已存在，则变更其值；
 * - 如果键不存在，请插入键值对。
 * - 当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。
 * 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用的键。
 */
public class LFUCache {
    private static class Node {
        int key, value, freq = 1;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> keyMap = new HashMap<>();
    private final Map<Integer, Node> freqMap = new HashMap<>();
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {                     // 如果有这个节点,更新节点
            node.value = value;
            return;
        }
        // 没有这个节点
        if (keyMap.size() == capacity) {        // 加入该节点会超出容量
            Node dummy = freqMap.get(minFreq);  // 找到最小频次节点链表,准备删除
            Node delNode = dummy.prev;
            keyMap.remove(delNode.key);         // 节点集合中删除
            remove(delNode);                    // 频次链表中删除该节点
            if (dummy.prev == dummy) {          // 移除该频次空链表
                freqMap.remove(minFreq);
            }
        }
        // 添加节点
        node = new Node(key, value);
        keyMap.put(key, node);
        pushFront(1, node);               // 放到频次为一的链表最前面
        minFreq = 1;                            // 重置最小频次
    }

    private Node getNode(int key) {
        if (!keyMap.containsKey(key)) {
            return null;
        }
        Node node = keyMap.get(key);
        remove(node);       // 抽出节点
        Node dummy = freqMap.get(node.freq);    // 环形链表
        if (dummy.prev == dummy) {              // 抽出后该链表如果变为空
            freqMap.remove(node.freq);          // 移除空链表
            if (minFreq == node.freq) {
                minFreq++;                      // 该链表为最小频次链表,且为空,此时访问次数又增加一次
            }
        }
        pushFront(++node.freq, node);
        return node;
    }

    private Node newList() {
        Node dummy = new Node(0,0); // 哨兵节点
        dummy.next = dummy;
        dummy.prev = dummy;
        return dummy;
    }

    private void pushFront(int freq, Node node) {
        // 将节点,放到该频次的最前面
        Node dummy = freqMap.computeIfAbsent(freq, k -> newList());
        node.prev = dummy;
        node.next = dummy.next;
        dummy.next.prev = node;
        dummy.next = node;
    }

    private void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}