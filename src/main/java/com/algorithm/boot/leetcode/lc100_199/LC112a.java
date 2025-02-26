package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 112. 路径总和
 * 简单
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *      如果存在，返回 true ；
 *      否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class LC112a {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.val == targetSum && root.right == null && root.left == null) return true;
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);
        return left || right;
    }

    /*
    1 2024年11月13日
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.val == targetSum && root.right == null && root.left == null) {
            return true;
        }
        targetSum -= root.val;
        return hasPathSum1(root.left, targetSum) || hasPathSum1(root.right, targetSum);
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        targetSum -= root.val;
        return hasPathSum2(root.left, targetSum) || hasPathSum2(root.right, targetSum);
    }
}