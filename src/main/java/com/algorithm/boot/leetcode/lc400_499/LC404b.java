package com.algorithm.boot.leetcode.lc400_499;

import com.algorithm.boot.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 404. 左叶子之和
 * 简单
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 */
public class LC404b {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arrayToTreeNode(new Integer[]{1,2,3,4,null,null,5});
        LC404b lc = new LC404b();
        System.out.println(lc.sumOfLeftLeaves(root));
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (isLeaf(root) && !stack.isEmpty() && stack.peek().left == root) ans += root.val;
            root = root.right;
        }
        return ans;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
