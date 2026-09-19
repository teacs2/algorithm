package com.algorithm.boot.other.HWod;

import java.util.Scanner;

/**
 * # 单词搜索计数
 * <p>
 * > 2026 华为OD机试真题8月30日华为OD上机新系统考试真题 200 分题型
 * <p>
 * 点击查看华为 OD 机试真题完整目录：2026最新华为OD机试新系统卷 + 双机位C卷 真题题库目录 | 全覆盖题库 + 逐点算法考点详解
 * <p>
 * ## 题目描述
 * <p>
 * 给定一个 `m×n` 的二维字符网格 `board` 和一个字符串 `word`。
 * <p>
 * 请计算单词 `word` 在网格中出现的总次数。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个搜索路径中不允许被重复使用。
 * <p>
 * ## 输入描述
 * <p>
 * `board`：二维字符列表，每个元素为大写英文字母，`1≤m,n≤10`。
 * <p>
 * `word`：字符串，由大写英文字母组成，`1≤len(word)≤100`。
 * <p>
 * ## 输出描述
 * <p>
 * 返回一个整数，表示单词在网格中出现的路径总数。
 * <p>
 * ## 示例1
 * <p>
 * ### 输入
 * <p>
 * ```text
 * [[A,B,C,E],[S,F,C,S],[A,D,E,E]]
 * ABCCED
 * ```
 * <p>
 * ### 输出
 * <p>
 * ```text
 * 1
 * ```
 * <p>
 * ## 示例2
 * <p>
 * ### 输入
 * <p>
 * ```text
 * [[A,A]]
 * A
 * ```
 * <p>
 * ### 输出
 * <p>
 * ```text
 * 2
 * ```
 * <p>
 * ### 说明
 * <p>
 * > 网格中有两个 `A`，每个都可以独立构成单词 A，共 2 条路径。
 * <p>
 * ## 示例3
 * <p>
 * ### 输入
 * <p>
 * ```text
 * [[A,B],[C,D]]
 * ABCD
 * ```
 * <p>
 * ### 输出
 * <p>
 * ```text
 * 0
 * ```
 * <p>
 * ### 说明
 * <p>
 * > 由于单词必须通过水平相邻或垂直相邻的单元格构成，导致 B 无法直接与 C 构成单词，所以网格中不存在 `ABCD` 的单词路径。
 */
public class OD0830c {

    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 计算单词在网格中出现的总次数
     *
     * @param board 二维字符网格
     * @param word  目标单词
     * @return 路径总数
     */
    public int countWordPaths(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    count += dfs(board, word, i, j, 0, visited);
                }
            }
        }
        return count;
    }

    private int dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        // 越界
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return 0;
        }
        // 已经走过
        if (visited[i][j]) {
            return 0;
        }
        // 当前格子不符合
        if (board[i][j] != word.charAt(index)) {
            return 0;
        }
        // 如果匹配到最后一个字符
        if (index == word.length() - 1) {
            return 1;
        }
        // 标记当前位置已使用
        visited[i][j] = true;
        int count = 0;
        for(int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            count += dfs (board, word, newI, newJ, index + 1, visited);
        }
        // 释放该位置
        visited[i][j] = false;
        return count;
    }


}