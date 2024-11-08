package com.algorithm.boot.leetcode.lc400_499;

/**
 * 430. 扁平化多级双向链表
 * 中等
 * 将链表扁平化
 */
public class LC430a {
    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    /**
     * 递归
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        Node dummy = new Node();
        dummy.next = head;
        while (head != null) {
            if (head.child == null) {
                head = head.next;
            } else {
                Node tmp = head.next;
                Node cHead = flatten(head.child);
                head.next = cHead;
                cHead.prev = head;
                while (head != null) head = head.next;
                head.next = tmp;
                if (tmp != null) tmp.prev = head;
                head = tmp;
            }
        }
        return dummy.next;
    }
}
