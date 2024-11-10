package com.algorithm.boot.leetcode.lc400_499;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 404. 左叶子之和
 * 简单
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 */
public class LC404a {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arrayToTreeNode(new Integer[]{3,9,20,null,null,15,7});
        LC404a lc = new LC404a();
        System.out.println(lc.sumOfLeftLeaves(root));
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root,false);
    }

    private int dfs(TreeNode node, boolean flag) {
        if (node == null) return 0;
        if (node.left == null && node.right == null && flag) return node.val;
        return dfs(node.left, true) + dfs(node.right, false);
    }
}
