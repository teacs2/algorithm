package com.algorithm.boot.other.HWod.od2026;

import java.util.Arrays;

public class OD0902c {

    /**
     * 无人机从 (0,0) 出发，巡检所有电力塔，
     * 求最短总飞行距离。
     * <p>
     * 巡检结束后不需要返回基地。
     *
     * @param towers 电力塔坐标 towers[i] = [x, y]
     * @return 最短飞行距离
     */
    public int minDistance(int[][] towers) {
        if (towers == null || towers.length == 0) {
            return 0;
        }

        int n = towers.length;

        // 记录distance[i][j]表示,共n个塔,表示 i 和 j 的距离
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] =
                        Math.abs(towers[i][0] - towers[j][0])
                        + Math.abs(towers[i][1] - towers[j][1]);
            }
        }
        // 记忆变量
        int[][] memo = new int[1 << n][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int startDistance =
                    Math.abs(towers[i][0])
                    + Math.abs(towers[i][1]);
            ans = Math.min(ans,
                    startDistance + dfs(1 << i, i, towers, distance, memo));
        }
        return ans;
    }

    private int dfs(int mask, int curr, int[][] towers, int[][] distance, int[][] memo) {
        int n = towers.length;
        // 所有塔的状态
        if (mask == (1 << n) - 1) {
            return 0;
        }
        if (memo[mask][curr] != -1) {
            return memo[mask][curr];
        }
        int ans = Integer.MAX_VALUE;
        for (int next = 0; next < n; next++) {
            // 如果下一个已经走过
            if ((mask & (1 << next)) != 0) {
                continue;
            }
            int newMask = mask | (1 << next);
            ans = Math.min(
                    ans,
                    distance[curr][next] + dfs(newMask, next, towers, distance, memo)
            );
        }
        memo[mask][curr] = ans;
        return ans;
    }

}
