package com.algorithm.boot.leetcode.lc900_999;

import com.algorithm.boot.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 971. 翻转二叉树以匹配先序遍历
 * 中等
 *
 */
public class LC971a {
    List<Integer> list;
    int[] voyage;
    int index;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        list = new ArrayList<>();
        index = 0;
        this.voyage = voyage;
        dfs(root);
        return list;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        if (node.val != voyage[index]) {
            list.clear();
            list.add(-1);
            return;
        }
        if (node.left != null && node.right != null) {
            // 交换
            if (node.right.val == voyage[index + 1]) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                list.add(node.val);
            } else if (node.left.val != voyage[index + 1] && node.right.val != voyage[index + 1]){
                list.clear();
                list.add(-1);
                return;
            }
        }

        if (node.left != null) {
            index++;
            dfs(node.left);
        }
        if (node.right != null) {
            index++;
            dfs(node.right);
        }
    }
}
