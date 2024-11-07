package com.algorithm.boot.leetcode.lc100_199;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 随机链表的复制
 * 中等
 */
public class LC138a {
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

    /**
     * 哈希表
     * key为源结点，value为拷贝的节点
     * 第一次遍历，新建所有节点存入hash表中
     * 第二次遍历，对应节点的关系
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Node cur = head;
        Map<Node, Node> cache = new HashMap<>();
        while (head != null) {
            cache.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node node = cache.get(cur);
            node.random = cache.get(cur.random);
            cur = cur.next;
            node.next = cache.get(cur);
        }
        return cache.get(head);
    }
}
