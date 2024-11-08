package com.algorithm.boot.leetcode.lc400_499;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 430. 扁平化多级双向链表
 * 中等
 * 将链表扁平化
 */
public class LC430b {
    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    /**
     * 栈回溯
     * 遇到,带子节点的,将next存入栈中,先遍历子链表,重复这个过程
     * 当节点为空时,弹出栈,拼接后,继续遍历,并重复上一步
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        Node node = head;
        Node prev = null;
        Deque<Node> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            if (node == null) {     // 遍历到了尾部,将带有子节点的出栈
                node = stack.pop();
                prev.next = node;
                node.prev = prev;
            }
            if (node.child != null) {
                if (node.next != null) stack.push(node.next);   // 将next先放入栈中,等把child链表遍历完后,接着遍历next
                node.child.prev = node;
                node.next = node.child;
                node.child = null;
            }
            prev = node;
            node = node.next;
        }
        return head;
    }
}
