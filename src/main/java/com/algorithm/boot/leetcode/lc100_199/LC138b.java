package com.algorithm.boot.leetcode.lc100_199;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 随机链表的复制
 * 中等
 */
public class LC138b {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node, Node> cache = new HashMap<>();
    /**
     * 回溯 + 哈希表
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (!cache.containsKey(head)) {
            Node copyNode = new Node(head.val);
            cache.put(head, copyNode);
            copyNode.next = copyRandomList(head.next);
            copyNode.random = copyRandomList(head.random);
        }
        return cache.get(head);
    }

    public Node copyRandomList1(Node head) {
        if (head == null) return null;
        if (!cache.containsKey(head)) {
            Node copyNode = new Node(head.val);
            cache.put(head, copyNode);
            copyNode.next = copyRandomList1(head.next);
            copyNode.random = copyRandomList1(head.random);
        }
        return cache.get(head);
    }
}
