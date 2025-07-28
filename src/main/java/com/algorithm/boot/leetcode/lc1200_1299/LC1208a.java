package com.algorithm.boot.leetcode.lc1200_1299;

public class LC1208a {
    /**
     * <a href="https://leetcode.cn/problems/get-equal-substrings-within-budget/description/">1208. 尽可能使字符串相等</a>
     * <pre>中等
     * 给你两个长度相同的字符串，s 和 t。
     *
     * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
     *
     * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
     *
     * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
     *
     * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
     *
     * 1 <= s.length, t.length <= 10^5
     * 0 <= maxCost <= 10^6
     * s 和 t 都只含小写英文字母。
     * </pre>
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public int equalSubstring(String s, String t, int maxCost) {
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        int res = 0;
        int cost = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            cost += Math.abs(S[r] - T[r]);
            while (cost > maxCost) {
                cost -= Math.abs(S[l] - T[l]);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
