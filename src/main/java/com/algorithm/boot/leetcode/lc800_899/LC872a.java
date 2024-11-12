package com.algorithm.boot.leetcode.lc800_899;

import com.algorithm.boot.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 * 简单
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 */
public class LC872a {
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.arrayToTreeNode(new Integer[]{1, 2, 128});
        TreeNode root2 = TreeNode.arrayToTreeNode(new Integer[]{1, 2, 128});
        LC872a lc = new LC872a();
        System.out.println(lc.leafSimilar(root1, root2));
    }

    /**
     * 递归
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
        if (node.left == null && node.right == null) list.add(node.val);
        if (node.left != null) getList(node.left, list);
        if (node.right != null) getList(node.right, list);
    }

    /*
    1 2024年11月12日
     */
    public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
        var list1 = new ArrayList<Integer>();
        var list2 = new ArrayList<Integer>();
        getList1(root1, list1);
        getList1(root2, list2);
        return list1.equals(list2);
    }

    private void getList1(TreeNode root, ArrayList<Integer> list) {
        if (root.left == null && root.right == null) list.add(root.val);
        if (root.left != null) getList1(root.left, list);
        if (root.right != null) getList1(root.right, list);
    }
}
