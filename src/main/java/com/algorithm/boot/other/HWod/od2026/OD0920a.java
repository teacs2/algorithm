package com.algorithm.boot.other.HWod.od2026;

/**
 * 华为 OD 机试题：字符串分组求和。
 * <p>
 * 给定一个字符串数组，每个字符串表示一个合法整数，可能带有正号或负号。
 * 只处理数组中的前 {@code n} 个成员，按照数字绝对值的大小分为以下四组：
 * <ol>
 *     <li>第 1 组：绝对值在 {@code [0, 100)} 范围内；</li>
 *     <li>第 2 组：绝对值在 {@code [100, 1000)} 范围内；</li>
 *     <li>第 3 组：绝对值在 {@code [1000, 10000)} 范围内；</li>
 *     <li>第 4 组：绝对值在 {@code [10000, +∞)} 范围内。</li>
 * </ol>
 * 分组依据是数字的绝对值，但求和使用数字原本的正负值。
 * 例如 {@code -50} 属于第 1 组，并为该组的和贡献 {@code -50}。
 * <p>
 * 返回长度为 4 的数组，依次表示四个分组的元素和。
 * 输入整数范围为 {@code [-10^6, 10^6]}，并保证
 * {@code 0 <= n <= numbers.length}。
 */
public class OD0920a {

    /**
     * 对数组中的前 {@code n} 个数字按照绝对值分组并求和。
     *
     * @param n       需要处理的数组成员数量
     * @param numbers 使用字符串表示的整数数组
     * @return 长度为 4 的数组，依次为四个绝对值区间的元素和
     */
    public int[] groupNumbersByAbsoluteValue(int n, String[] numbers) {
        // write code here
        int[] result = new int[4];
        if (n == 0) {
            return result;
        }

        long g1 = 0;
        long g2 = 0;
        long g3 = 0;
        long g4 = 0;

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(numbers[i]);
            long absNum = Math.abs(num);
            if (absNum < 100 && absNum >= 0) {
                g1 += num;
            }
            if (absNum < 1000 && absNum >= 100) {
                g2 += num;
            }
            if (absNum < 10000 && absNum >= 1000) {
                g3 += num;
            }
            if (absNum >= 10000) {
                g4 += num;
            }
        }
        result[0] = (int) g1;
        result[1] = (int) g2;
        result[2] = (int) g3;
        result[3] = (int) g4;

        return result;
    }
}
