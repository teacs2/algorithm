package com.algorithm.boot.leetcode.lc700_799;

/**
 * 707. 设计链表
 * 中等
 */
public class MyLinkedList {
    private class Node {
        int val;
        Node prev;
        Node next;

    }
    private Node dummy; // 环状链表的哨兵节点
    public MyLinkedList() {
        dummy = new Node();
        dummy.next = dummy;
        dummy.prev = dummy;
    }

    public int get(int index) {
        return 0;
    }

    public void addAtHead(int val) {

    }

    public void addAtTail(int val) {

    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }
}
