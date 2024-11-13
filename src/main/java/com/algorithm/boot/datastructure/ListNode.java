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
}
