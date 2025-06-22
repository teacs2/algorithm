package com.algorithm.boot.leetcode.lc1_99;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/">17. 电话号码的字母组合</a>
 * 中等
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LC17a {
    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return List.of();
        }
        List<String> res = new ArrayList<>();
        char[] path = new char[n];
        dfs(0, res, path, digits.toCharArray());
        return res;
    }

    private void dfs(int i, List<String> res, char[] path, char[] digits) {
        if (i == digits.length) {
            res.add(new String(path));
            return;
        }
        String letters = MAPPING[digits[i] - '0'];
        for (char c : letters.toCharArray()) {
            path[i] = c;
            dfs(i + 1, res, path, digits);
        }
    }
}
