package com.algorithm.boot.leetcode.lc600_699;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 671. 二叉树中第二小的节点
 * 简单
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
 * 如果第二小的值不存在的话，输出 -1 。
 */
public class LC671a {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arrayToTreeNode(new Integer[]{1, 1, 1, 1, 5, 1, 4});
        LC671a lc = new LC671a();
        System.out.println(lc.findSecondMinimumValue(root));
    }
    int min;
    int secondMin = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null) return -1;
        min = root.val;
        dfs(root);
        return secondMin == min ? -1 : secondMin;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        if (secondMin != -1 && secondMin >= node.val) return;
        if (node.val < secondMin && node.val > min) secondMin = node.val;
        dfs(node.left);
        dfs(node.right);
    }
}
