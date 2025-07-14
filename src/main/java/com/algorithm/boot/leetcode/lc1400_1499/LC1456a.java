package com.algorithm.boot.leetcode.lc1400_1499;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">1456. 定长子串中元音的最大数目</a>
 * 给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。
 */
public class LC1456a {
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int res = 0;
        int vowel = 0;
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                vowel++;
            }
            if (i < k - 1) {
                continue;
            }
            res = Math.max(res, vowel);
            if (set.contains(chars[i - k + 1])) {
                vowel--;
            }
        }
        return res;
    }
}
