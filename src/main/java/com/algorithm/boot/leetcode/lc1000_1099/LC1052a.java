package com.algorithm.boot.leetcode.lc1000_1099;

public class LC1052a {
    /**
     * <a href="https://leetcode.cn/problems/grumpy-bookstore-owner/">1052. 爱生气的书店老板 可爱捏</a>中等
     * <p>有一个书店老板，他的书店开了 <code>n</code> 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 <code>n</code> 的整数数组 <code>customers</code> ，其中 <code>customers[i]</code> 是在第 <code>i</code> 分钟开始时进入商店的顾客数量，所有这些顾客在第 <code>i</code> 分钟结束后离开。</p>
     * <p>在某些分钟内，书店老板会生气。 如果书店老板在第 <code>i</code> 分钟生气，那么 <code>grumpy[i] = 1</code>，否则 <code>grumpy[i] = 0</code>。</p>
     * <p>当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。</p>
     * <p>书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 <code>minutes</code> 分钟不生气，但却只能使用一次。</p>
     * <p>请你返回 <em>这一天营业下来，最多有多少客户能够感到满意</em> 。</p>
     * @param customers
     * @param grumpy
     * @param minutes
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // 老板不压制情绪时，感到满意的顾客数量
        int satisfied = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }

        // 滑动窗口内不满意顾客
        int notSatisfied = 0;
        int maxNotSatisfied = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                notSatisfied += customers[i];
            }
            if (i < minutes - 1) {
                continue;
            }
            maxNotSatisfied = Math.max(maxNotSatisfied, notSatisfied);
            if (grumpy[i - minutes + 1] == 1) {
                notSatisfied -= customers[i - minutes + 1];
            }
        }
        return satisfied + maxNotSatisfied;
    }
}
