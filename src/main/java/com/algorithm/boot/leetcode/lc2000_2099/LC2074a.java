package com.algorithm.boot.leetcode.lc2000_2099;

import com.algorithm.boot.datastructure.ListNode;

import java.util.ArrayList;

public class LC2074a {

    /**
     * 交换节点的值,没交换节点
     * @param head
     * @return
     */
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        int size = 1;
        for (ListNode node = head; node != null; node = node.next) {
            nodes.add(node);
            if (nodes.size() == size || node.next == null) {    // 统计到 size 个节点，或到达链表末尾
                int n = nodes.size();
                if (n % 2 == 0) {                               // 有偶数个节点
                    for (int i = 0; i < n / 2; i++) {
                        int temp = nodes.get(i).val;
                        nodes.get(i).val = nodes.get(n - 1 - i).val;
                        nodes.get(n - 1 - i).val = temp;
                    }
                }
                nodes.clear();
                size++;
            }
        }
        return head;
    }

    /*
    2024年11月10日
     */
    public ListNode reverseEvenLengthGroups1(ListNode head) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        int size = 1;
        for (ListNode node = head; node != null; node = node.next) {
            nodes.add(node);
            if (nodes.size() == size || node.next == null) {    // 每统计1,2,3,4...个节点或者到达末尾时,判断该区间节点是否为偶数个
                int n = nodes.size();
                if (n % 2 == 0) {   // 需要翻转
                    for (int i = 0; i < n / 2; i++) {
                        int temp = nodes.get(i).val;
                        nodes.get(i).val = nodes.get(n - 1 - i).val;
                        nodes.get(n - 1 - i).val = temp;
                    }
                }
                nodes.clear();
                size++;
            }
        }
        return head;
    }
}
