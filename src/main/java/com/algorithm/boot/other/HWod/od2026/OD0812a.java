package com.algorithm.boot.other.HWod.od2026;

import java.util.Arrays;

public class OD0812a {

    /**
     * 选择尽可能多的互不重叠请求。
     * <p>
     * 注意：
     * 区间是闭区间，因此 [1,3] 和 [3,5] 也属于重叠。
     *
     * @param requests requests[i] = [Li, Ri]
     * @return 最多可以同时选择的请求数量
     */
    public int maxBatch(int[][] requests) {
        if (requests == null || requests.length == 0) {
            return 0;
        }
        Arrays.sort(requests, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int count = 0;
        int lastEnd = -1;
        for (int[] request : requests) {
            int left = request[0];
            int right = request[1];
            if (left > lastEnd) {
                count++;
                lastEnd = right;
            }
        }
        return count;
    }
}
