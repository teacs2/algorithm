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
}
