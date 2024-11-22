package com.algorithm.boot.leetcode.lc1300_1399;

import com.algorithm.boot.datastructure.ListNode;
import com.algorithm.boot.datastructure.TreeNode;

/**
 * 1367. 二叉树中的链表
 * 中等
 * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 */
public class LC1367a {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        // 先判断当前节点 || 再判断左子树 || 再判断右子树
        return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean isSub(ListNode head, TreeNode node) {
        // head为空，说明链表走完了
        if (head == null) {
            return true;
        }
        // 子树走完了，但链表没走完
        if (node == null) {
            return false;
        }
        // 值不相同，不行
        if (head.val != node.val) {
            return false;
        }
        // 值相同，继续判断子节点
        return isSub(head.next, node.left) || isSub(head.next, node.right);
    }
}
