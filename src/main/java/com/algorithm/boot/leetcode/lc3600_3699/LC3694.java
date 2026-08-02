package com.algorithm.boot.leetcode.lc3600_3699;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/distinct-points-reachable-after-substring-removal/description/">3694. 删除子字符串后不同的终点</a>
 */
public class LC3694 {

    private static final int[][] DIRS = new int[128][];

    static {
        DIRS['U'] = new int[]{0, 1};
        DIRS['D'] = new int[]{0, -1};
        DIRS['L'] = new int[]{-1, 0};
        DIRS['R'] = new int[]{1, 0};
    }

    public int distinctPoints(String s, int k) {
        int len = s.length();
        Set<Long> set = new HashSet<>();
        int x = 0;
        int y = 0;
        for (int i = 0; i < len; i++) {
            char in = s.charAt(i);
            x += DIRS[in][0];
            y += DIRS[in][1];
            int left = i - k + 1;
            if (left < 0) {
                continue;
            }
            set.add((long)(x + len) << 20 | (y + len));

            char out = s.charAt(left);
            x -= DIRS[out][0];
            y -= DIRS[out][1];
        }
        return set.size();
    }
}
