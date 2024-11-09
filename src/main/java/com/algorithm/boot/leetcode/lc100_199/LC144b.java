package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * 144. 二叉树的前序遍历
 * 已解答
 * 简单
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class LC144b {

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            list.add(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left == null && !stack.isEmpty()) {
                root = stack.pop();
            } else {
                root = root.left;
            }
        }
        return list;
    }
}
