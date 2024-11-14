package com.algorithm.boot.leetcode.lc1400_1499;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 1448. 统计二叉树中好节点的数目
 * 中等
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * <p>
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 */
public class LC1448a {

    /**
     * dfs 只需要维护路径上的最大值
     *
     * @param root
     * @return
     */
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int maxNum) {
        if (root == null) return 0;
        int res = root.val >= maxNum ? 1 : 0;
        return res + dfs(root.left, Math.max(maxNum, root.val)) + dfs(root.right, Math.max(maxNum, root.val));
    }

    /*
    1 2024年11月14日
     */
    public int goodNodes1(TreeNode root) {
        return dfs1(root, root.val);
    }

    private int dfs1(TreeNode node, int maxNum) {
        if (node == null) return 0;
        maxNum = Math.max(node.val, maxNum);
        int res = node.val >= maxNum ? 1 : 0;
        return dfs1(node.left, maxNum) + dfs1(node.right, maxNum) + res;
    }
}
