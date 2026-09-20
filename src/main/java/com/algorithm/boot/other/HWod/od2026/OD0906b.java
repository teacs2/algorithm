package com.algorithm.boot.other.HWod.od2026;

import java.util.Arrays;

public class OD0906b {

    /**
     * 求到达最后一关能够获得的最大累计分数。
     * <p>
     * 移动规则：
     * 1. 每次可以前进1关或者2关
     * 2. 不能连续两次都跳2关
     *
     * @param n      关卡数量
     * @param values 第1~n关的分值
     * @return 最大累计分数
     */
    public int maxScore(int n, int[] values) {
        if (n <= 0 || values == null || values.length == 0) {
            throw new IllegalArgumentException("参数不合法");
        }

        int[][] dp = new int[n][2];

        int negInf = Integer.MIN_VALUE / 2;

        for (int[] row : dp) {
            Arrays.fill(row, negInf);
        }
        dp[0][0] = values[0];

        for (int i = 1; i < n; i++) {
            // 从i - 1来
            dp[i][0] = values[i] + Math.max(dp[i - 1][0], dp[i - 1][1]);

            // 从i - 2来
            if (i >= 2) {
                dp[i][1] = values[i] + dp[i - 2][0];
            }
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

}
