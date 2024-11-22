package com.algorithm.boot.leetcode.lc700_799;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 * 中等
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。
 * 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 */
public class LC701a {
    /**
     * 递归
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        dfs(root, val);
        return root;
    }

    private void dfs(TreeNode node, int val) {
        if (node == null) return;
        if (node.val < val) {
            if (node.right == null) {
                node.right = new TreeNode(val);
                return;
            }
            dfs(node.right, val);
        }
        if (node.val > val){
            if (node.left == null) {
                node.left = new TreeNode(val);
                return;
            }
            dfs(node.left, val);
        }
    }
}
