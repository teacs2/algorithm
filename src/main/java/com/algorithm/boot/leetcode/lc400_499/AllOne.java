package com.algorithm.boot.leetcode.lc400_499;

import java.util.*;

/**
 * 432. 全 O(1) 的数据结构
 * 困难
 */
public class AllOne {
    public static void main(String[] args) {
        var allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        allOne.inc("world");
        allOne.inc("world");
        allOne.inc("hello");
        allOne.dec("world");
        String maxKey = allOne.getMaxKey();
        String minKey = allOne.getMinKey();
        allOne.inc("world");
        allOne.inc("world");
        allOne.inc("leet");
        maxKey = allOne.getMaxKey();
        minKey = allOne.getMinKey();
        allOne.inc("leet");
        allOne.inc("leet");
        minKey = allOne.getMinKey();

    }
    private static class Node {
        int cnt;
        Set<String> set = new HashSet<>();
        Node prev, next;
        Node(int cnt) {
            this.cnt = cnt;
        }
    }

    Node dummy;     // 由set构成的环形链表
    Map<String, Node> map = new HashMap<>();
    public AllOne() {
        dummy = new Node(0);
        dummy.next = dummy;
        dummy.prev = dummy;
    }
    public void inc(String key) {
        // 1. 检查索引map中是否存在该key
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.set.remove(key);
            Node nxt = null;
            // 判断是否需要新建节点（1.下一个节点为dummy,2.下一个节点>cnt+1）
            if (node.next == dummy || node.next.cnt > node.cnt + 1) {
                nxt = new Node(node.cnt + 1);
                insertNode(node, nxt);  // 插入节点
            } else {
                nxt = node.next;
            }
            nxt.set.add(key);
            map.put(key, nxt);
            clear(node);        // 清理原来的节点,如果为空,移除
        } else {
            Node node = null;
            // 是否存在cnt为1的节点
            if (dummy.next.cnt == 1) {
                // 1.不需要新建节点,直接加入
                node = dummy.next;
            } else {
                node = new Node(1);
                insertNode(dummy, node);
            }
            node.set.add(key);
            map.put(key, node);
        }
    }

    public void dec(String key) {
        if (!map.containsKey(key)) return;
        Node node = map.get(key);
        node.set.remove(key);
        if (node.cnt == 1) {
            map.remove(key);
        } else {
            Node prev = null;
            if (node.prev.cnt == node.cnt - 1) {
                prev = node.prev;
            } else {
                prev = new Node(node.cnt- 1);
                insertNode(node.prev, prev);
            }
            prev.set.add(key);
            map.put(key, prev);
        }
        clear(node);
    }

    public String getMaxKey() {
        for (String str : dummy.prev.set) return str;
        return "";
    }

    public String getMinKey() {
        for (String str : dummy.next.set) return str;
        return "";
    }

    private void clear(Node node) {
        if (node.set.isEmpty()) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    /**
     * 插入节点 将node插到prev后面
     * @param prev  插入位置
     * @param node  待插入节点
     */
    private void insertNode(Node prev, Node node) {
        Node nxt = prev.next;
        prev.next = node;
        nxt.prev = node;
        node.prev = prev;
        node.next = nxt;
    }
}
