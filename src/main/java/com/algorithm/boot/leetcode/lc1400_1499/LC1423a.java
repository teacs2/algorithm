package com.algorithm.boot.leetcode.lc1400_1499;

public class LC1423a {
    /**
     * <a href="https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/">1423. 可获得的最大点数</a>中等
     * <p>几张卡牌 <strong>排成一行</strong>，每张卡牌都有一个对应的点数。点数由整数数组 <code>cardPoints</code> 给出。</p>
     *
     * <p>每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 <code>k</code> 张卡牌。</p>
     *
     * <p>你的点数就是你拿到手中的所有卡牌的点数之和。</p>
     *
     * <p>给你一个整数数组 <code>cardPoints</code> 和整数 <code>k</code>，请你返回可以获得的最大点数。</p>
     * @param cardPoints    整数数组 cardPoints
     * @param k             k 张卡牌
     * @return              可以获得的最大点数
     */
    public int maxScore(int[] cardPoints, int k) {
        int maxScore = 0;
        int score = 0;
        for (int i = cardPoints.length - k; i < cardPoints.length + k; i++) {
            int index = i >= cardPoints.length ? i % cardPoints.length : i;
            score += cardPoints[index];
            if (i < cardPoints.length - 1) {
                continue;
            }
            maxScore = Math.max(maxScore, score);
            index = i - k + 1;
            if (index == cardPoints.length) {
                index = 0;
            }
            score -= cardPoints[index];
        }
        return maxScore;
    }
}
