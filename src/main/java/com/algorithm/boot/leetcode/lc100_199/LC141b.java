package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.ListNode;

public class LC141b {
    /**
     * 方法二 快慢指针，龟兔赛跑，如果有环，兔子必定会追上与乌龟重合，反之则无环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
