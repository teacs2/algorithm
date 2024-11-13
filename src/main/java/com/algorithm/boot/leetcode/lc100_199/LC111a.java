package com.algorithm.boot.leetcode.lc100_199;

import com.algorithm.boot.datastructure.TreeNode;

/**
 * 111. 二叉树的最小深度
 * 简单
 */
public class LC111a {
    /**
     * 深度优先搜索
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depthLeft = 0;
        if (root.left != null) {
            depthLeft = minDepth(root.left);
        }
        int depthRight = 0;
        if (root.right != null) {
            depthRight = minDepth(root.right);
        }

        return depthLeft != 0 && depthRight != 0 ?
                Math.min(depthLeft, depthRight) + 1 : Math.max(depthRight, depthLeft) + 1;
    }

    /*
    1 2024年11月13日
     */
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        int depthLeft = 0;
        if (root.left != null) {
            depthLeft = minDepth1(root.left);
        }
        int depthRight = 0;
        if (root.right != null) {
            depthRight = minDepth1(root.right);
        }
        return depthLeft != 0 && depthRight != 0 ?
                Math.min(depthLeft, depthRight) + 1 : Math.max(depthRight, depthLeft) + 1;
    }
}
