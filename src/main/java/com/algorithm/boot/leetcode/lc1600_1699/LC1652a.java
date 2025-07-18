package com.algorithm.boot.leetcode.lc1600_1699;

public class LC1652a {
    /**
     * <a href="https://leetcode.cn/problems/defuse-the-bomb/">1652. 拆炸弹 简单</a>
     * <p>你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 <code>n</code> 的 <strong>循环</strong> 数组 <code>code</code> 以及一个密钥 <code>k</code> 。</p>
     * <p>为了获得正确的密码，你需要替换掉每一个数字。所有数字会 <strong>同时</strong> 被替换。</p>
     * <ul>
     *   <li>如果 <code>k > 0</code> ，将第 <code>i</code> 个数字用 <strong>接下来</strong> <code>k</code> 个数字之和替换。</li>
     *   <li>如果 <code>k < 0</code> ，将第 <code>i</code> 个数字用 <strong>之前</strong> <code>k</code> 个数字之和替换。</li>
     *   <li>如果 <code>k == 0</code> ，将第 <code>i</code> 个数字用 <code>0</code> 替换。</li>
     * </ul>
     * <p>由于 <code>code</code> 是循环的， <code>code[n-1]</code> 下一个元素是 <code>code[0]</code> ，且 <code>code[0]</code> 前一个元素是 <code>code[n-1]</code> 。</p>
     * <p>给你 <strong>循环</strong> 数组 <code>code</code> 和整数密钥 <code>k</code> ，请你返回解密后的结果来拆除炸弹！</p>
     * @param code
     * @param k
     * @return
     */
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        // 初始窗口右边界（开区间）
        int r = k > 0 ? k + 1 : n;
        k = Math.abs(k);
        int s = 0;            
        // 计算ans[0]
        for (int i = r - k; i < r; i++) {
            s += code[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = s;
            s += code[r % n] - code[(r - k) % n];
            r++;
        }
        return res;
    }
}
