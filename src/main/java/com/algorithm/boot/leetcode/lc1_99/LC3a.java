package com.algorithm.boot.leetcode.lc1_99;

public class LC3a {
    public int lengthOfLongestSubstring(String s) {
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
}
