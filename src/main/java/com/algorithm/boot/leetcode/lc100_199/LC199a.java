package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
/**
 * 199. 二叉树的右视图
 * 中等
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class LC199a {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (root == null) return;
        if (depth == ans.size()) ans.add(root.val);   // 这个深度首次遇到
        dfs(root.right, depth + 1, ans);        // 先递归右子树，保证首次遇到的一定是最右边的节点
        dfs(root.left, depth + 1, ans);
    }

    /*
    1 2024年11月14日
     */
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs1(root, 0, list);
        return list;
    }

    private void dfs1(TreeNode node, int depth, List<Integer> list) {
        if (node == null) return;
        if (depth == list.size()) list.add(node.val);
        dfs1(node.right, depth + 1, list);
        dfs1(node.left, depth + 1, list);
    }
}
