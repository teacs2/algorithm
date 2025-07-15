package com.algorithm.boot.leetcode.lc900_999;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/rotting-oranges/">994. 腐烂的橘子 中等</a>
 * <pre>
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * </pre>
 */
public class LC994a {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 新鲜橘子个数
        int fresh = 0;
        // 腐烂橘子队列
        List<int[]> queue = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 统计新鲜橘子
                    fresh++;
                } else if (grid[i][j] == 2) {
                    // 记录初始腐烂橘子
                    queue.add(new int[]{i, j});
                }
            }
        }

        int res = 0;
        // fresh > 0 因为最后一个被腐烂的橘子仍然 会 循环判断一次,此时如果没有加该条件, res会++;
        while (fresh > 0 && !queue.isEmpty()) {
            res++;
            List<int[]> tmp = queue;
            queue = new ArrayList<>();
            for (int[] pos : tmp) {
                for (int[] d : DIRECTIONS) {
                    int i = pos[0] + d[0];
                    int j = pos[1] + d[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
                        fresh--;
                        grid[i][j] = 2;
                        queue.add(new int[]{i, j});
                    }
                }
            }
        }
        return fresh > 0 ? -1 : res;
    }
}
