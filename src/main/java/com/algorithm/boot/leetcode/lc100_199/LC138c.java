package com.algorithm.boot.leetcode.lc100_199;

/**
 * 138. 随机链表的复制
 * 中等
 */
public class LC138c {
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
     * 迭代
     * 将复制节点插在原节点后面
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 在原节点后新建复制节点，复制节点值
        for (Node cur = head; cur != null; cur = cur.next.next) {
            Node nxt = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = nxt;
        }
        // 复制随机指针
        for (Node cur = head; cur != null; cur = cur.next.next) {
            Node curNew = cur.next;
            if (cur.random == null) curNew.random = null;
            else curNew.random = cur.random.next;
        }
        // 拆分节点
        Node headNew = head.next;
        for (Node cur = head; cur != null; cur = cur.next) {
            Node curNew = cur.next;
            cur.next = curNew.next;
            curNew.next = (curNew.next != null) ? curNew.next.next : null;
        }
        return headNew;
    }
}
