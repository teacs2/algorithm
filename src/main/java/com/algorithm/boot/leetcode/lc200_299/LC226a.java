package com.algorithm.boot.leetcode.lc200_299;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/invert-binary-tree/description">226. 翻转二叉树</a>
 * 简单
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class LC226a {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null || node.right != null) {
            TreeNode tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
