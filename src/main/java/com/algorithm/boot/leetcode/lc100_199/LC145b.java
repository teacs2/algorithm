package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;

import java.util.*;

/**
 * 145. 二叉树的后序遍历
 * 已解答
 * 简单
 */
public class LC145b {

    /**
     * 递归a 栈 + 预指针
     * 通过加入一个,上一次添加节点,用来判断右子树是否添加
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalA(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prevAdd = null;    // 上一个加入答案的节点
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);    // 入栈
                root = root.left;   // 移至左节点
            }
            root = stack.pop();     // 为空,出栈
            if (root.right == null || root.right == prevAdd) {  // 如果又子树为空,或者上一个添加的节点是有节点,则添加当前节点
                list.add(root.val);
                prevAdd = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }

    /**
     * 递归b 栈 + set集合
     * 用set集合来表示已经访问过的节点
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalB(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> visited = new TreeSet<>();
        while (root != null || !stack.isEmpty()) {
            if (root == null && visited.contains(stack.peek())) {
                list.add(stack.pop().val);
            } else if (root == null) {
                visited.add(stack.peek());
                root = stack.peek().right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        return list;
    }
}