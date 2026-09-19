package com.algorithm.boot.other.HWod.od2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OD0902b {

    /**
     * 合并发生重叠或边界接触的螳螂领地。
     *
     * @param originalLand 原始领地，每个元素为 [start, end]
     * @return 合并后的领地，按照起点升序排列
     */
    public int[][] mergeLand(int[][] originalLand) {
        if (originalLand == null || originalLand.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(originalLand, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int start = originalLand[0][0];
        int end = originalLand[0][1];
        for (int i = 1; i < originalLand.length; i++) {
            int nextStart = originalLand[i][0];
            int nextEnd = originalLand[i][1];
            if (nextStart <= end) {
                end = Math.max(end, nextEnd);
            } else {
                result.add(new int[]{start, end});
                start = nextStart;
                end = nextEnd;
            }
        }
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}
