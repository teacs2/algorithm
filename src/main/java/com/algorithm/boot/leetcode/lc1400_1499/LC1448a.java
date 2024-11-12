package com.algorithm.boot.leetcode.lc1400_1499;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 1448. 统计二叉树中好节点的数目
 * 中等
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 *
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 */
public class LC1448a {
    public static void main(String[] args) {
        var root = TreeNode.arrayToTreeNode(new Integer[]{
                -1,
                5,-2,
                4,4,2,-2,
                null,null,-4,null,-2,3,null,-2,
                0,null,-1,null,-3,null,-4,-3,
                3,null,null,null,null,null,null,null,3,-3});
        var lc = new LC1448a();
        System.out.println(lc.goodNodes(root));
    }
    /**
     * dfs 只需要维护路径上的最大值
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
}
