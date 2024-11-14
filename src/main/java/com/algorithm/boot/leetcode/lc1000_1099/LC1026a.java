package com.algorithm.boot.leetcode.lc1000_1099;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 1026. 节点与其祖先之间的最大差值
 * 中等
 *
 */
public class LC1026a {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int max, int min) {
        if (node == null) return 0;
        int cur = Math.max(Math.abs(node.val - max), Math.abs(node.val) - min);
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        int left = dfs(node.left, max, min);
        int right = dfs(node.right, max, min);
        return Math.max(cur, Math.max(left, right));
    }
}
