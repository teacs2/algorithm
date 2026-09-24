package com.algorithm.boot.other.HWod.od2026;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class OD0920cTest {

    private final OD0920c solution = new OD0920c();

    @ParameterizedTest(name = "测试用例 {index}: n={0}, k={1}, expected={2}")
    @CsvSource(
            value = {
                    // ==================================================
                    // 1. 官方示例1
                    // ==================================================
                    // 两个合法排列的差值均为 1、2
                    "3 | 3 | [[2,1,3],[2,3,1]]",

                    // ==================================================
                    // 2. 官方示例2
                    // ==================================================
                    // k=2 时没有连续三个元素需要比较，
                    // 因此所有长度为2的排列都合法
                    "4 | 2 | [[1,2],[1,3],[1,4],[2,1],[2,3],[2,4]," +
                            "[3,1],[3,2],[3,4],[4,1],[4,2],[4,3]]",

                    // ==================================================
                    // 3. k=1
                    // ==================================================
                    // [1,n] 中每个数字都能单独构成合法排列
                    "4 | 1 | [[1],[2],[3],[4]]",

                    // ==================================================
                    // 4. k>3
                    // ==================================================
                    // 两个合法排列的差值均为 1、2、3
                    "4 | 4 | [[2,3,1,4],[3,2,4,1]]",

                    // ==================================================
                    // 5. 最大边界 n=8, k=8
                    // ==================================================
                    // 两个合法排列的差值均为 1、2、3、4、5、6、7
                    "8 | 8 | [[4,5,3,6,2,7,1,8],[5,4,6,3,7,2,8,1]]"
            },
            delimiter = '|'
    )
    void testFindSequences(int n, int k, String expectedStr) {
        int[][] expected = parseMatrix(expectedStr);

        int[][] actual = solution.findSequences(n, k);

        assertArrayEquals(expected, actual);
    }

    /**
     * 覆盖题目规定的全部合法 n、k 组合。
     * <p>
     * 对照结果由独立的全排列枚举生成，并按题目条件过滤。
     * 枚举数字始终从小到大，因此期望结果同时也是字典序。
     */
    @Test
    void testAllValidNAndK() {
        for (int n = 1; n <= 8; n++) {
            for (int k = 1; k <= n; k++) {
                int[][] expected = generateExpected(n, k);
                int[][] actual = solution.findSequences(n, k);

                assertArrayEquals(
                        expected,
                        actual,
                        "n=" + n + ", k=" + k
                );
            }
        }
    }

    private int[][] generateExpected(int n, int k) {
        List<int[]> result = new ArrayList<>();
        int[] sequence = new int[k];
        boolean[] used = new boolean[n + 1];

        generateExpected(0, n, sequence, used, result);

        return result.toArray(int[][]::new);
    }

    /**
     * 将：
     * <p>
     * [[2,1,3],[2,3,1]]
     * <p>
     * 转换为二维int数组。
     */
    private int[][] parseMatrix(String str) {
        String content = str.replace(" ", "").trim();

        if ("[]".equals(content)) {
            return new int[0][0];
        }

        content = content.substring(2, content.length() - 2);
        String[] rows = content.split("\\],\\[");
        int[][] result = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String[] nums = rows[i].split(",");
            result[i] = new int[nums.length];

            for (int j = 0; j < nums.length; j++) {
                result[i][j] = Integer.parseInt(nums[j]);
            }
        }

        return result;
    }

    private void generateExpected(
            int index,
            int n,
            int[] sequence,
            boolean[] used,
            List<int[]> result) {

        if (index == sequence.length) {
            result.add(sequence.clone());
            return;
        }

        for (int num = 1; num <= n; num++) {
            if (used[num]) {
                continue;
            }

            sequence[index] = num;

            if (index >= 2) {
                int previousDiff = Math.abs(
                        sequence[index - 2] - sequence[index - 1]
                );
                int currentDiff = Math.abs(
                        sequence[index - 1] - sequence[index]
                );

                if (previousDiff >= currentDiff) {
                    continue;
                }
            }

            used[num] = true;
            generateExpected(index + 1, n, sequence, used, result);
            used[num] = false;
        }
    }
}
