package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 129. 求根节点到叶节点数字之和
 * 中等
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 */
public class LC129a {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int val) {
        if (root == null) return 0;
        int cur = val * 10 + root.val;
        if (root.left == null && root.right == null) return cur;
        return dfs(root.left, val * 10 + root.val) + dfs(root.right, val * 10 + root.val);
    }

    /*
    1 2024年11月12日
     */
    private int dfs1(TreeNode root, int val) {
        if (root == null) return 0;
        int cur = val * 10 + root.val;
        if (root.left == null && root.right == null) return cur;
        return dfs1(root.left, cur) + dfs1(root.right, cur);
    }

    /*
    2 2024年11月14日
     */
    public int sumNumbers2(TreeNode root) {
        return dfs2(root, 0);
    }

    private int dfs2(TreeNode node, int val) {
        if (node == null) return 0;
        int cur = val * 10 + node.val;
        if (node.left == null && node.right == null) {
            return cur;
        }
        return dfs2(node.left, cur) + dfs2(node.right, cur);
    }
}
