package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;

public class LC101a {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null ^ right == null) return false;
        else if (left.val != right.val) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
