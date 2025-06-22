package com.algorithm.boot.leetcode.lc400_499;

import com.algorithm.boot.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/path-sum-iii/description/">437. 路径总和 III</a>
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class LC437a {
    private int res;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> cnt = new HashMap<>();   // 以当前节点为终点，前缀和为key个数为value的哈希表
        cnt.put(0L, 1);
        dfs(root, 0L, targetSum, cnt);
        return res;
    }

    private void dfs(TreeNode node, long s, int targetSum, Map<Long, Integer> cnt) {
        if (node == null) {
            return;
        }

        s += node.val;
        res += cnt.getOrDefault(s - targetSum, 0);

        cnt.merge(s, 1, Integer::sum);
        dfs(node.left, s, targetSum, cnt);
        dfs(node.right, s, targetSum, cnt);
        cnt.merge(s, -1, Integer::sum);
    }
}
