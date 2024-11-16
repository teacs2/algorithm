package com.algorithm.boot.leetcode.lc900_999;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 965. 单值二叉树
 * 简单
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 */
public class LC965a {
    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode node, int val) {
        if (node == null) return true;
        if (node.val != val) return false;
        return dfs(node.left, val) && dfs(node.right, val);
    }
}
