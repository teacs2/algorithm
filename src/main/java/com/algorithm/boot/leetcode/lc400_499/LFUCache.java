package com.algorithm.boot.leetcode.lc400_499;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU 缓存
 * 困难
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 *
 * 实现 LFUCache 类：
 *  LFUCache(int capacity)
 *   - 用数据结构的容量 capacity 初始化对象
 *  int get(int key)
 *   - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 *  void put(int key, int value)
 *   - 如果键 key 已存在，则变更其值；
 *   - 如果键不存在，请插入键值对。
 *       - 当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。
 *         在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用的键。
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

    public int get(int key){
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
    }

    private Node getNode(int key) {

        return null;
    }
}
