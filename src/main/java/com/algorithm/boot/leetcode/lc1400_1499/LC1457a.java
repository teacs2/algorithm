package com.algorithm.boot.leetcode.lc1400_1499;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 1457. 二叉树中的伪回文路径
 * 中等
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 * 给定二叉树的节点数目在范围 [1, 10^5] 内
 * 1 <= Node.val <= 9
 */
public class LC1457a {
    public static void main(String[] args) {
        var root = TreeNode.arrayToTreeNode(new Integer[]{2,1,1,1,3,null,null,null,null,null,1});
        var lc = new LC1457a();
        System.out.println(lc.pseudoPalindromicPaths(root));
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        var counter = new int[10];
        return dfs(root, counter);
    }

    private int dfs(TreeNode node, int[] counter) {
        if (node == null) return 0;
        counter[node.val]++;
        int res = 0;
        if (isLeaf(node)) {
            if (isPseudoPalindromic(counter)) res++;
        } else {
            res = dfs(node.left, counter) + dfs(node.right, counter);
        }
        counter[node.val]--;
        return res;
    }

    private boolean isPseudoPalindromic(int[] counter) {
        int odd = 0;
        for (int num : counter) {
            odd += num % 2;
        }
        return odd <= 1;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
