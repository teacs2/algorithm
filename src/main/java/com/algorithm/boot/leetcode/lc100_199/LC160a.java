package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LC160a {
    /**
     * 哈希表  性能一般
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
