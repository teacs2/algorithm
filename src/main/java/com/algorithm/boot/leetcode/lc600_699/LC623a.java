package com.algorithm.boot.leetcode.lc600_699;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 623. 在二叉树中增加一行
 * 中等
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
 * 注意，根节点 root 位于深度 1 。
 * 加法规则如下:
 * - 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * - cur 原来的左子树应该是新的左子树根的左子树。
 * - cur 原来的右子树应该是新的右子树根的右子树。
 * - 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 */
public class LC623a {
    int val;
    int depth;

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        this.val = val;
        this.depth = depth;
        TreeNode dummy = new TreeNode(0, root, null);
        dfs(dummy, 0);
        return dummy.left;
    }

    private void dfs(TreeNode node, int curDepth) {
        if (node == null) return;
        if (curDepth + 1 == depth) {
            TreeNode oddLeft = node.left;
            TreeNode oddRight = node.right;
            TreeNode newLeft = new TreeNode(val, oddLeft, null);
            TreeNode newRight = new TreeNode(val, null, oddRight);
            node.left = newLeft;
            node.right = newRight;
            return;
        }
        dfs(node.left, curDepth + 1);
        dfs(node.right, curDepth + 1);
    }
}
