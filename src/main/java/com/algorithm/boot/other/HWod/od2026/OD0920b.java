package com.algorithm.boot.other.HWod.od2026;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 华为 OD 机试题：简单 URL 路径提取器。
 * <p>
 * 给定一组 URL 路径，提取每个 URL 的所有路径前缀，并统计每个路径前缀
 * 在全部 URL 中出现的次数。例如，URL {@code /a/b/c} 包含以下路径前缀：
 * <pre>
 * /a
 * /a/b
 * /a/b/c
 * </pre>
 * 只保留出现次数不少于 2 次的路径前缀，每个结果的格式为
 * {@code "路径前缀 出现次数"}。
 * <p>
 * 排序规则：
 * <ol>
 *     <li>出现次数不同，按出现次数从大到小排列；</li>
 *     <li>出现次数相同，按路径前缀的字典序升序排列。</li>
 * </ol>
 * 根路径 {@code /} 只有在输入 URL 本身为 {@code /} 时才参与统计，
 * 不会由其他 URL 自动产生。URL 中的 {@code .} 作为普通路径字符处理。
 * <p>
 * 题目约束：URL 仅包含小写英文字母、{@code /} 和 {@code .}，
 * 所有 URL 的总长度不超过 {@code 10^6}。
 */
public class OD0920b {

    /**
     * 提取出现次数不少于 2 次的 URL 路径前缀。
     *
     * @param urls 待处理的 URL 列表
     * @return 按出现次数降序、路径前缀字典序升序排列的统计结果
     */
    public ArrayList<String> processUrlExtract(ArrayList<String> urls) {
        Map<String, Integer> prefixCount = new HashMap<>();

        for (String url : urls) {
            for (int end = 1; end <= url.length(); end++) {
                if (end == url.length() || url.charAt(end) == '/') {
                    String prefix = url.substring(0, end);
                    prefixCount.merge(prefix, 1, Integer::sum);
                }
            }
        }

        List<Map.Entry<String, Integer>> repeatedPrefixes = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : prefixCount.entrySet()) {
            if (entry.getValue() >= 2) {
                repeatedPrefixes.add(entry);
            }
        }

        repeatedPrefixes.sort(
                Comparator
                        .<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey)
        );

        ArrayList<String> result = new ArrayList<>(repeatedPrefixes.size());
        for (Map.Entry<String, Integer> entry : repeatedPrefixes) {
            result.add(entry.getKey() + " " + entry.getValue());
        }

        return result;
    }
}
