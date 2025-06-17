package com.algorithm.boot.leetcode.lc1300_1399;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 1372. 二叉树中的最长交错路径
 * 中等
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 *  - 选择二叉树中 任意 节点和一个方向（左或者右）。
 *  - 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 *  - 改变前进方向：左变右或者右变左。
 *  - 重复第二步和第三步，直到你在树中无法继续移动。
 *  - 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 * 请你返回给定树中最长 交错路径 的长度。
 * 每棵树最多有 50000 个节点。
 * 每个节点的值在 [1, 100] 之间。
 */
public class LC1372a {
    int res;
    public int longestZigZag(TreeNode root) {
        res = 0;
        dfs(root,0, 0);
        return res;
    }

    /**
     * 递归，记录最长交叉路径
     * @param node 节点
     * @param len 当前交叉长度
     * @param path -1: 向左, 0: 初始, 1: 向右
     */
    private void dfs(TreeNode node, int len, int path) {
        if (node == null) return;
        res = Math.max(res, len);
        if (node.left == null && node.right == null) return;
        int leftLen = path != -1 ? len + 1 : 1;
        int rightLen = path != 1 ? len + 1 : 1;
        dfs(node.left, leftLen, -1);
        dfs(node.right, rightLen, 1);
    }

    /*
    2025年3月22日
     */
    public int longestZigZag1(TreeNode root) {
        res = 0;
        dfs1(root, 0, 0);
        return res;
    }

    private void dfs1(TreeNode node, int len, int path) {
        if (node == null) return;
        res = Math.max(len, res);
        if (node.left == null && node.right == null) return;
        int leftLen = path != -1 ? len + 1 : 1;
        int rightLen = path != 1 ? len + 1 : 1;
        dfs1(node.left, leftLen, -1);
        dfs1(node.right, rightLen, 1);
    }
}
