package com.algorithm.boot.leetcode.lc500_599;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree/description/">543. 二叉树的直径</a>
 * 简单
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class LC543a {
    private int res;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int lLen = dfs(node.left) + 1;
        int rLen = dfs(node.right) + 1;
        res = Math.max(res, lLen + rLen);
        return Math.max(lLen, rLen);
    }
}
