package com.algorithm.boot.leetcode.lc700_799;

import com.algorithm.boot.datastructure.ListNode;

public class LC725a {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        int mod = length % k;
        int div = length / k;
        ListNode[] ans = new ListNode[k];
        ListNode curr = head;
        ListNode temp = null;
        if (length >= k) {
            for (int i = 0; i < k; i++) {
                ans[i] = curr;
                for (int j = 0; j < div; j++) {
                    temp = curr;
                    curr = curr.next;
                }
                if (mod-- > 0) {
                    temp = curr;
                    curr = curr.next;
                }
                temp.next = null;
            }
        } else {
            for (int i = 0; i < k; i++) {
                if (curr != null) {
                    ans[i] = curr;
                    temp = curr;
                    curr = curr.next;
                    temp.next = null;
                }
            }
        }
        return ans;
    }

    /*
    2025年2月12日
     */
    public ListNode[] splitListToParts1(ListNode head, int k) {
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        int mod = length % k;
        int div = length / k;
        ListNode[] res = new ListNode[k];
        ListNode curr = head;
        ListNode temp = null;
        if (length >= k) {
            for (int i = 0; i < k; i++) {
                res[i] = curr;
                for (int j = 0; j < div; j++) {
                    temp = curr;
                    curr = curr.next;
                }
                if (mod-- > 0) {
                    temp = curr;
                    curr = curr.next;
                }
                temp.next = null;
            }
        } else {
            for (int i = 0; i < k; i++) {
                if (curr != null) {
                    res[i] = curr;
                    temp = curr;
                    curr = curr.next;
                    temp.next = null;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildFromArray(new Integer[]{1, 2, 3,4,5,6,7,8,9,10});

        LC725a lc725a = new LC725a();
        ListNode[] listNodes = lc725a.splitListToParts1(head, 3);
        System.out.println(listNodes);
    }
}
