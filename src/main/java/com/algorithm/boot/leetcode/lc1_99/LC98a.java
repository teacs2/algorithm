package com.algorithm.boot.leetcode.lc1_99;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/validate-binary-search-tree/">98. 验证二叉搜索树</a>
 * <pre>中等
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 *      节点的左子树只包含 小于 当前节点的数。
 *      节点的右子树只包含 大于 当前节点的数。
 *      所有左子树和右子树自身必须也是二叉搜索树。<pre/>
 */
public class LC98a {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }
        long num = node.val;
        return num < right && num > left &&
                dfs(node.left, left, num) &&
                dfs(node.right, num, right);
    }

}
