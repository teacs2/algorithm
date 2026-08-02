package com.algorithm.boot.leetcode.lc3000_3099;

/**
 * <a href="https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/description/">3090. 每个字符最多出现两次的最长子字符串</a>
 */
public class LC3090a {
    public int maximumLengthSubstring1(String s) {
        char[] chars = s.toCharArray();
        int[] cnt = new int[128];
        int res = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = chars[r];
            cnt[c]++;
            while (cnt[c] > 2) {
                cnt[chars[l++]]--;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public int maximumLengthSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] cnt = new int[128];
        int res = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = chars[r];
            cnt[c]++;
            while (cnt[c] > 2) {
                cnt[chars[l++]]--;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
