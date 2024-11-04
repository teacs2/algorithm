package com.algorithm.boot.leetcode.lc1200_1299;

import com.algorithm.boot.datastructure.ListNode;

public class LC1290a {
    public int getDecimalValue(ListNode head) {
        ListNode currNode = head;
        int ans = 0;
        while (currNode != null) {
            // java中 + 优先级高于位运算，不加上括号一直都是0 * 2 或者0 * 4
            ans = (ans << 1) + currNode.val;
            currNode = currNode.next;
        }
        return ans;
    }
}
