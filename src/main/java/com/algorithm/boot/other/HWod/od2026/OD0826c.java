package com.algorithm.boot.other.HWod.od2026;

import java.util.HashSet;
import java.util.Set;

public class OD0826c {

    /**
     * 计算每位员工的最终绩效。
     * <p>
     * result[i] =
     * 员工i自己的基础绩效
     * + 左子树所有员工绩效
     * + 右子树所有员工绩效
     *
     * @param n     员工数量
     * @param left  左下属编号，-1表示没有
     * @param right 右下属编号，-1表示没有
     * @param base  每位员工的基础绩效
     * @return 每位员工的最终绩效
     */
    public int[] calculatePerformance(
            int n,
            int[] left,
            int[] right,
            int[] base) {

        int[] result = new int[n];

        // 找到根节点
        boolean[] hasParent = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (left[i] != -1) {
                hasParent[left[i]] = true;
            }
            if (right[i] != -1) {
                hasParent[right[i]] = true;
            }
        }
        int root = 0;
        for (int i = 0; i < n; i++) {
            if (!hasParent[i]) {
                root = i;
                break;
            }
        }

        // 后续遍历
        dfs(root, left, right, base, result);
        return result;
    }

    private int dfs(int curr, int[] left, int[] right, int[] base, int[] result) {
        if (left[curr] == -1 && right[curr] == -1) {
            result[curr] = base[curr];
            return base[curr];
        }

        int leftBase = 0;
        if (left[curr] != -1) {
            leftBase = dfs(left[curr], left, right, base, result);
        }
        int rightBase = 0;
        if (right[curr] != -1) {
            rightBase = dfs(right[curr], left, right, base, result);
        }
        int currBase = leftBase + rightBase + base[curr];
        result[curr] = currBase;
        return currBase;
    }
}
