package com.algorithm.boot.other.HWod.od2026;

import java.util.ArrayList;
import java.util.List;

/**
 * 华为 OD 0920c机试题：递增差排列。
 * <p>
 * 给定两个整数 {@code n} 和 {@code k}，从 {@code [1, n]} 中选择
 * {@code k} 个互不相同的整数，组成长度为 {@code k} 的排列。
 * 对排列中的任意连续三个元素 {@code a[i]、a[i+1]、a[i+2]}，要求满足：
 * <pre>
 * |a[i] - a[i+1]| &lt; |a[i+1] - a[i+2]|
 * </pre>
 * 即排列中相邻元素的绝对差值必须从左到右严格递增。
 * 当 {@code k < 3} 时，没有连续三个元素需要检查，因此所有不重复排列都合法。
 * <p>
 * 结果按照字典序升序返回；如果不存在合法排列，则返回空二维数组。
 * 题目约束：{@code 1 <= k <= n <= 8}。
 * <p>
 * 示例：当 {@code n=3, k=3} 时，合法结果为：
 * <pre>
 * [[2,1,3],[2,3,1]]
 * </pre>
 */
public class OD0920c {


    /**
     * 查找所有满足相邻差值严格递增的排列。
     *
     * @param n 可使用的整数上限，数字范围为 {@code [1, n]}
     * @param k 每个排列的长度
     * @return 按字典序排列的所有合法排列
     */
    public int[][] findSequences(int n, int k) {
        List<int[]> result = new ArrayList<>();
        int[] path = new int[k];
        boolean[] used = new boolean[n + 1];

        dfs(0, n, k, path, used, result);

        return result.toArray(int[][]::new);
    }

    /**
     * 使用回溯构造排列。候选数字从小到大枚举，因此结果自然符合字典序。
     */
    private void dfs(int depth, int n, int k, int[] path, boolean[] used, List<int[]> result) {
        if (depth == k) {
            // path 会在后续回溯中继续修改，因此保存它的副本。
            result.add(path.clone());
            return;
        }

        for (int num = 1; num <= n; num++) {
            if (used[num]) {
                continue;
            }
            path[depth] = num;

            // 每加入一个数字，只需验证最新形成的三个连续元素。
            if (depth >= 2
                    && Math.abs(path[depth - 2] - path[depth - 1])
                    >= Math.abs(path[depth - 1] - path[depth])) {
                continue;
            }
            used[num] = true;
            dfs(depth + 1, n, k, path, used, result);
            used[num] = false;
        }
    }
}
