package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.ListNode;

public class LC160b {

    public static void main(String[] args) {
        var headA = ListNode.buildFromArray(new Integer[]{1, 2});
        var headB = ListNode.buildFromArray(new Integer[]{6, 7, 8});

        LC160b b = new LC160b();
        ListNode node = b.getIntersectionNode(headA, headB);
    }

    /**
     * 双指针
     * 链表可分为两种情况，
     * - 相交
     *  将链表分别分成两段表示
     *  - aList： a + c
     *  - bList： b + c
     *  如果ab相等，
     *      则相交时直接返回
     *  ab不相等
     *      a遍历完后指向b，b遍历完后指向a
     *      a指针： a -> c -> b -> c
     *      b指针： b -> c -> a -> c
     *      此时ab走过的路程会相同，当ab指针相等时直接返回
     * - 不相交
     *      a指针： a -> b -> null
     *      b指针： b -> a -> null
     *      同时指向null
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
