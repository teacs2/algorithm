package com.algorithm.boot.datastructure;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildFromArray(Integer[] array) {
        if (array == null) return new ListNode();
        ListNode head = new ListNode(array[0]);
        ListNode curr = head;
        for (int i = 1; i < array.length; i++) {
            curr.next = new ListNode(array[i]);
            curr = curr.next;
        }
        return head;
    }

    public static int[] listToArray(ListNode head) {
        int len = getLength(head);
        var arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = head.val;
            head = head.next;
        }
        return arr;
    }

    public static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    @Override
    public boolean equals(Object obj) {
        // 如果比较的对象是自身，直接返回 true
        if (this == obj) {
            return true;
        }

        // 如果比较的对象是 null 或者不是 ListNode 类型，返回 false
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // 类型转换
        ListNode other = (ListNode) obj;

        // 比较当前节点的值
        if (this.val != other.val) {
            return false;
        }

        // 递归比较下一个节点
        if (this.next == null) {
            return other.next == null;
        } else {
            return this.next.equals(other.next);
        }
    }

    @Override
    public int hashCode() {
        // 为了保持 equals 和 hashCode 的一致性，我们也需要重写 hashCode 方法
        int result = val;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}
