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
    int depthMax;
    List<Integer> list;
    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, 1);
        return list;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > depthMax) list.add(root.val);   // 更深,加入值
        depthMax = Math.max(depth, depthMax);       // 更新最大深度
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }
}
