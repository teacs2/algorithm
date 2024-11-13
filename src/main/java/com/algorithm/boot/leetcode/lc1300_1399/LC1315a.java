package com.algorithm.boot.leetcode.lc1300_1399;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 1315. 祖父节点值为偶数的节点和
 * 中等
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * - 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 *
 * 树中节点的数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 */
public class LC1315a {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, -1, -1);
    }

    private int dfs(TreeNode root, int p, int gp) {
        if (root == null) return 0;
        int ans = 0;
        if (gp % 2 == 0) {
            ans += root.val;
        }
        return dfs(root.left, root.val, p) + dfs(root.right, root.val, p) + ans;
    }
}
