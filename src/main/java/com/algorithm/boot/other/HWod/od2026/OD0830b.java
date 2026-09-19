package com.algorithm.boot.other.HWod.od2026;

import java.util.*;

public class OD0830b {

    /**
     * 快递驿站计费
     * <p>
     * 规则：
     * 1. 存放时间 <= 12 小时，免费
     * 2. 超过 12 小时后，每 12 小时收费 1 元，不足 12 小时按 12 小时计算
     * 3. 同一房间号的所有快递费用累加
     * 4. 按总费用降序排序，总费用相同时按房间号升序排序
     * <p>
     * records[i][0]：存件时间
     * records[i][1]：取件时间
     * records[i][2]：房间号
     *
     * @param records 快递存取记录
     * @return [房间号, 总费用]
     */
    public int[][] calculateFees(int[][] records) {
        if (records == null || records.length == 0) {
            return new int[0][2];
        }
        Map<Integer, Integer> feeMap = new HashMap<>(records.length);
        for (int[] record : records) {
            int startTime = record[0];
            int endTime = record[1];
            int room = record[2];
            int duration = endTime - startTime;
            int fee = calculateSingleFee(duration);
            feeMap.merge(room, fee, Integer::sum);
        }

        List<int[]> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : feeMap.entrySet()) {
            result.add(new int[]{entry.getKey(), entry.getValue()});
        }
        result.sort((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        return result.toArray(new int[result.size()][]);
    }

    /**
     * 计算单个快递的费用
     */
    private int calculateSingleFee(int duration) {
        if (duration <= 12) {
            return 0;
        }
        int overTime = duration - 12;
        return (overTime + 11) / 12;
    }
}