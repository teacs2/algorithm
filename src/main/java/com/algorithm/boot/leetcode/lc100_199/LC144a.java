package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 已解答
 * 简单
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class LC144a {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }
}
