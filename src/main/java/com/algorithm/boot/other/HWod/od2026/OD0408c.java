package com.algorithm.boot.other.HWod.od2026;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 华为 OD 机试题：直捣黄龙。
 * <p>
 * 敌军阵营是一个 {@code n * n} 的方形矩阵，左上角坐标为 {@code (0,0)}，
 * 右下角坐标为 {@code (n-1,n-1)}。入口位于 {@code (0,n/2)}，
 * 敌军司令部位于 {@code (n-1,n/2)}。
 * <p>
 * 地图中分布着若干哨兵。每个哨兵能够发现以自己为中心的九宫格区域，
 * 即行坐标和列坐标与哨兵位置的差值都不超过 1 的位置。
 * 九宫格超出地图边界的部分忽略。角色一旦进入任意哨兵的监控区域，行动失败。
 * <p>
 * 角色每次只能向上、下、左、右移动一格，即一次移动中行坐标和列坐标
 * 不能同时发生变化。需要找到从入口到司令部的所有最短安全路径。
 * <p>
 * 返回一个长度为 2 的数组：
 * <ol>
 *     <li>第一个元素表示最短路径的条数；</li>
 *     <li>第二个元素表示最短路径长度。</li>
 * </ol>
 * 路径长度按照路径中包含的坐标数量计算，包括起点和终点。
 * 例如一条路径经过 7 个位置，则路径长度为 7，而不是移动次数 6。
 * 如果不存在满足条件的路径，返回 {@code [0,0]}。
 * <p>
 * 题目约束：{@code n} 是大于 1 且小于 30 的奇数，坐标从 0 开始。
 */
public class OD0408c {

    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};


    /**
     * 统计从入口到敌军司令部的最短安全路径数量及路径长度。
     *
     * @param n        敌军阵营方阵的边长
     * @param sentries 哨兵坐标，{@code sentries[i] = [x, y]}，
     *                 {@code x} 表示行坐标，{@code y} 表示列坐标
     * @return {@code [最短路径条数, 最短路径长度]}，无路可达时返回 {@code [0,0]}
     */
    public int[] findShortestPaths(int n, int[][] sentries) {

        // 标记哨兵监视范围
        boolean[][] blocked = new boolean[n][n];
        for (int[] sentry : sentries) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int x = sentry[0] + i;
                    int y = sentry[1] + j;
                    if (x < 0 || x >= n || y < 0 || y >= n) {
                        continue;
                    }
                    blocked[x][y] = true;
                }
            }
        }

        int[][] distance = new int[n][n];
        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }
        long[][] ways = new long[n][n];

        int startX = 0;
        int startY = n / 2;
        distance[startX][startY] = 0;
        ways[startX][startY] = 1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currX = current[0];
            int currY = current[1];

            for (int[] direction : DIRECTIONS) {
                int nextX = currX + direction[0];
                int nextY = currY + direction[1];
                // 1.判断是否越界
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                    continue;
                }
                // 2.判断是否处于哨兵区域
                if (blocked[nextX][nextY]) {
                    continue;
                }
                // 3.更新最短距离和数量
                if (distance[nextX][nextY] == -1) {
                    distance[nextX][nextY] = distance[currX][currY] + 1;
                    ways[nextX][nextY] = ways[currX][currY];
                    queue.offer(new int[]{nextX, nextY});
                } else if (distance[currX][currY] + 1 == distance[nextX][nextY]) {
                    ways[nextX][nextY] += ways[currX][currY];
                }
            }
        }
        int endX = n - 1;
        int endY = n / 2;
        if (distance[endX][endY] == -1) {
            return new int[]{0, 0};
        }

        return new int[] {
                (int) ways[endX][endY],
                distance[endX][endY] + 1
        };
    }
}
