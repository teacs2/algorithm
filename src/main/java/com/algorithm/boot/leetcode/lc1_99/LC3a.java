package com.algorithm.boot.leetcode.lc1_99;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">3. 无重复字符的最长子串<a/>
 */
public class LC3a {
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] cnt = new int[128];
        int res = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            char c = chars[r];
            cnt[c]++;
            while (cnt[c] > 1) {
                cnt[chars[l]]--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int res = 0;
        int[] cnt = new int[128];
        int l = 0;
        for (int r = 0; r < n; r++) {
            char c = chars[r];
            cnt[c]++;
            while (cnt[c] > 1) {
                cnt[chars[l]]--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
