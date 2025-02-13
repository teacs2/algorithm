package com.algorithm.boot.leetcode.lc800_899;

import com.algorithm.boot.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 872. 叶子相似的树
 * 简单
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 */
public class LC872b {
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.arrayToTreeNode(new Integer[]{1, 2});
        TreeNode root2 = TreeNode.arrayToTreeNode(new Integer[]{1, null,2});
        LC872b lc = new LC872b();
        System.out.println(lc.leafSimilar(root1, root2));
    }

    /**
     * 迭代
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        getList(root1, list1);
        getList(root2, list2);
        if (list1.size() != list2.size()) return false;
        return list1.equals(list2);
    }

    private void getList(TreeNode node, List<Integer> list) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else if (node == null && !stack.isEmpty()) {
                node = stack.pop();
                if (node.left == null && node.right == null) list.add(node.val);
                node = node.right;
            }
        }
    }

    /*
    2025年2月13日
     */
    public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        getList1(root1, list1);
        getList1(root2, list2);
        if (list1.size() != list2.size()) return false;
        return list1.equals(list2);
    }

    private void getList1(TreeNode root, List<Integer> list) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.left == null && root.right == null) list.add(root.val);
            root = root.right;
        }
    }
}
