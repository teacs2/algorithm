package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 104. 二叉树的最大深度
 * 简单
 */
public class LC104a {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth1 = maxDepth(root.left);
        int depth2 = maxDepth(root.right);
        return Math.max(depth1, depth2) + 1;
    }

    /*
    1. 2024年11月13日
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return Math.max(left, right) + 1;
    }

    /*
    2. 2025年2月15日
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        return Math.max(left, right) + 1;
    }
}
