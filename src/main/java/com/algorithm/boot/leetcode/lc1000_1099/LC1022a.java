package com.algorithm.boot.leetcode.lc1000_1099;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 1022. 从根到叶的二进制数之和
 * 简单
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * <p>
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 */
public class LC1022a {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int num) {
        if (node == null) return 0;
        num = (num << 1) + node.val;
        if (node.left == null && node.right == null) {
            return num;
        }
        int left = dfs(node.left, num);
        int right = dfs(node.right, num);
        return left + right;
    }

}
