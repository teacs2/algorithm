package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 100. 相同的树
 * 简单
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class LC100a {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null ^ q == null) return false;
        else if (p.val != q.val) return false;
        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }
}
