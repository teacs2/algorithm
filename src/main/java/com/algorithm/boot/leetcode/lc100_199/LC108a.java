package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/">108. 将有序数组转换为二叉搜索树</a>
 * 简单
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 */
public class LC108a {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int m = (left + right) >>> 1;
        TreeNode node = new TreeNode(nums[m]);
        node.left = dfs(nums, left, m);
        node.right = dfs(nums,m + 1, right);
        return node;
    }
}
