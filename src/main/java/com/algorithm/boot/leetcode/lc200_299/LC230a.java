package com.algorithm.boot.leetcode.lc200_299;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/">230. 二叉搜索树中第 K 小的元素</a>
 * 中等
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 */
public class LC230a {
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftRes = dfs(node.left);
        if (leftRes != -1) {
            return leftRes;
        }
        if (--k == 0) {
            return node.val;
        }
        return dfs(node.right);
    }
}
