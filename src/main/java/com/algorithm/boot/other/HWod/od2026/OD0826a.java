package com.algorithm.boot.other.HWod.od2026;

import java.util.Arrays;

public class OD0826a {

    /**
     * 仓库查询。
     * <p>
     * 第 i 次查询：
     * 在前 B[i] 个货物中，查询第 i+1 小的价格。
     *
     * @param n 货物数量
     * @param m 查询次数
     * @param A 货物价格
     * @param B 每次查询使用的前缀长度
     * @return 每次查询的结果
     */
    public int[] warehouseQuery(int n, int m, int[] A, int[] B) {
        int[] answer = new int[m];

        Integer[] order = new Integer[m];

        for (int i = 0; i < m; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (i, j) -> Integer.compare(B[i], B[j]));

        int[] sorted = new int[n];

        int size = 0;

        // 已经入库的数量
        int currentCount = 0;

        for (int queryIndex : order) {
            int needCount = B[queryIndex];

            // 加入当前需要的物品
            while (currentCount < needCount) {
                int price = A[currentCount];
                // 插入有序数组
                int pos = size;
                while (pos > 0 && sorted[pos - 1] > price) {
                    sorted[pos] = sorted[pos - 1];
                    pos--;
                }
                sorted[pos] = price;
                size++;
                currentCount++;
            }
            answer[queryIndex] = sorted[queryIndex];
        }
        return answer;
    }
}
