package com.algorithm.boot.leetcode.lc900_999;

import com.algorithm.boot.datastructure.TreeNode;

import java.util.TreeSet;

/**
 * 988. 从叶结点开始的最小字符串
 * 中等
 * 给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个 [0, 25] 范围内的值，分别代表字母 'a' 到 'z'。
 * 返回 按字典序最小 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 *  注：字符串中任何较短的前缀在 字典序上 都是 较小 的：
 *     - 例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。
 * 节点的叶节点是没有子节点的节点。
 */
public class LC988a {
    String ans = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append((char) ('a' + node.val));
        if (node.left == null && node.right == null) {
            sb.reverse();
            String s = sb.toString();
            sb.reverse();

            if (s.compareTo(ans) < 0) {
                ans = s;
            }
        }
        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);   // 回到外一层，移除拼接字符
    }

    /*
    1 2024年11月13日
     */
    public String smallestFromLeaf1(TreeNode root) {
        dfs1(root, new StringBuilder());
        return ans;
    }

    private void dfs1(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append((char) ('a' + node.val));
        if (node.left == null && node.right == null) {
            sb.reverse();
            String s = sb.toString();
            sb.reverse();
            if (s.compareTo(ans) < 0) ans = s;
        }
        dfs1(node.left, sb);
        dfs1(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
