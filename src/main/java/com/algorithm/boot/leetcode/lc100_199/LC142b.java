package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.ListNode;

public class LC142b {
    /**
     * 方法二 快慢指针
     * 如果有环
     *  快慢指针相遇的时候，增加第三个指针，从head出发，慢指针继续移动，相遇位置，第三个指针也必然会到达相遇点，因为慢指针也走了两倍的距离，
     *  如果速度相同想要相遇，则必然是在入环的时候就相遇，所以第三个指针与慢指针第一次相同时，就是环的起点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
