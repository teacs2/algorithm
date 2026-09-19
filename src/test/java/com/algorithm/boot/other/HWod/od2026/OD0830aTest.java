package com.algorithm.boot.other.HWod.od2026;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OD0830aTest {

    private final OD0830a solution = new OD0830a();

    @ParameterizedTest(name = "测试用例 {index}: nums={0}, k={1}, expected={2}")
    @CsvSource(
            value = {
                    // ========================
                    // 1. 题目官方示例
                    // ========================

                    // 12,17,18,20 -> 最大20
                    "1,3,8,6,4,10 | 3 | 20",

                    // ========================
                    // 2. 最小边界
                    // ========================

                    // 数组只有一个元素
                    "5 | 1 | 5",

                    // 单个负数
                    "-5 | 1 | -5",

                    // ========================
                    // 3. k = 1
                    // ========================

                    // 此时等价于寻找最大元素
                    "-3,7,4,-1 | 1 | 7",

                    // 全部负数
                    "-10,-5,-20 | 1 | -5",

                    // ========================
                    // 4. k = nums.length
                    // ========================

                    // 只能选择整个数组
                    "1,-2,3,4 | 4 | 6",

                    "10,-5,-2 | 3 | 3",

                    // ========================
                    // 5. 普通正常情况
                    // ========================

                    // [4,-1,2]=5
                    // [-1,2,10]=11
                    // [2,10,-3]=9
                    // [10,-3,5]=12
                    "4,-1,2,10,-3,5 | 3 | 12",

                    // 最大值出现在中间
                    "1,2,10,20,-100,1 | 2 | 30",

                    // ========================
                    // 6. 最大窗口在最左边
                    // ========================

                    // [10,-1]=9
                    // [-1,-1]=-2
                    // [-1,-1]=-2
                    "10,-1,-1,-1 | 2 | 9",

                    // ========================
                    // 7. 最大窗口在最右边
                    // ========================

                    // [-1,-1]=-2
                    // [-1,5]=4
                    // [5,6]=11
                    "-1,-1,5,6 | 2 | 11",

                    // ========================
                    // 8. 全部为负数
                    // ========================

                    // [-5,-2]=-7
                    // [-2,-8]=-10
                    "-5,-2,-8 | 2 | -7",

                    // 用于检查 maxSum 是否错误初始化为0
                    // [-10,-20]=-30
                    // [-20,-30]=-50
                    "-10,-20,-30 | 2 | -30",

                    // ========================
                    // 9. 重复元素
                    // ========================

                    "2,2,2,2 | 2 | 4",

                    "5,5,5,5,5 | 3 | 15",

                    // ========================
                    // 10. 多个窗口具有相同最大值
                    // ========================

                    // [1,2]=3
                    // [2,1]=3
                    // [1,2]=3
                    // [2,1]=3
                    "1,2,1,2,1 | 2 | 3",

                    // ========================
                    // 11. 0元素
                    // ========================

                    "0,0,0,0 | 2 | 0",

                    "0,-1,0,-1,0 | 1 | 0",

                    // ========================
                    // 12. 正负交替
                    // ========================

                    // [10,-10,10]=10
                    // [-10,10,-10]=-10
                    // [10,-10,10]=10
                    "10,-10,10,-10,10 | 3 | 10",

                    // ========================
                    // 13. 大数，验证long
                    // ========================

                    // 2147483647 * 3
                    "2147483647,2147483647,2147483647 | 3 | 6442450941",

                    // Integer.MIN_VALUE * 2
                    "-2147483648,-2147483648 | 2 | -4294967296",

                    // ========================
                    // 14. int 最大最小值混合
                    // ========================

                    // [MAX, MIN] = -1
                    // [MIN, MAX] = -1
                    "2147483647,-2147483648,2147483647 | 2 | -1",

                    // ========================
                    // 15. 窗口不断变化
                    // ========================

                    // [1,2,3] = 6
                    // [2,3,4] = 9
                    // [3,4,5] = 12
                    // [4,5,6] = 15
                    "1,2,3,4,5,6 | 3 | 15",

                    // 递减数组，最大窗口在开头
                    // [6,5,4] = 15
                    "6,5,4,3,2,1 | 3 | 15",

                    // ========================
                    // 16. 容易写错窗口移出元素下标
                    // ========================

                    // [100,1,1]=102
                    // [1,1,50]=52
                    // [1,50,50]=101
                    // 正确答案102
                    "100,1,1,50,50 | 3 | 102"
            },
            delimiter = '|'
    )
    void testMaxSum(String numsStr, int k, long expected) {
        int[] nums = parseArray(numsStr);

        long actual = solution.maxSum(nums, k);

        assertEquals(expected, actual);
    }

    /**
     * 非法k：k = 0
     */
    @Test
    void testKIsZero() {
        int[] nums = {1, 2, 3};

        assertThrows(
                IllegalArgumentException.class,
                () -> solution.maxSum(nums, 0)
        );
    }

    /**
     * 非法k：k大于数组长度
     */
    @Test
    void testKGreaterThanArrayLength() {
        int[] nums = {1, 2, 3};

        assertThrows(
                IllegalArgumentException.class,
                () -> solution.maxSum(nums, 4)
        );
    }

    /**
     * null数组
     */
    @Test
    void testNullArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> solution.maxSum(null, 1)
        );
    }

    /**
     * 空数组
     */
    @Test
    void testEmptyArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> solution.maxSum(new int[0], 1)
        );
    }

    /**
     * 将：
     *
     * "1,3,8,6,4,10"
     *
     * 转换为：
     *
     * new int[]{1,3,8,6,4,10}
     */
    private int[] parseArray(String str) {
        str = str.trim();

        if (str.isEmpty()) {
            return new int[0];
        }

        String[] parts = str.split(",");

        int[] nums = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i].trim());
        }

        return nums;
    }
}