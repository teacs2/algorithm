package com.algorithm.boot.leetcode.lc3400_3499;

public class LC3439a {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] free = new int[n + 1];
        free[0] = startTime[0];
        for (int i = 1; i <= n - 1; i++) {
            free[i] = startTime[i] - endTime[i - 1];
        }
        free[n] = eventTime - endTime[n - 1];

        int sum = 0;
        int res = 0;
        for (int i = 0; i <= n; i++) {
            sum += free[i];
            if (i < k) {
                continue;
            }
            res = Math.max(res, sum);
            sum -= free[i - k];
        }
        return res;
    }
}
