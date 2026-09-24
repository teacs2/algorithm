package com.algorithm.boot.other.HWod.od2026;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OD0920bTest {

    private final OD0920b solution = new OD0920b();

    @ParameterizedTest(name = "测试用例 {index}: urls={0}, expected={1}")
    @CsvSource(
            value = {
                    // ==================================================
                    // 1. 官方示例1
                    // ==================================================
                    "/api/v1/users/list,/api/v1/users/detail,/api/v1/orders,/api/v2/products" +
                            " | /api 4;/api/v1 3;/api/v1/users 2",

                    // ==================================================
                    // 2. 官方示例2：出现次数相同，按字典序排列
                    // ==================================================
                    "/admin,/api.js,/admin,/api.js | /admin 2;/api.js 2",

                    // ==================================================
                    // 3. 官方示例3：根路径只统计输入中的根路径
                    // ==================================================
                    "/,/ | / 2",

                    // ==================================================
                    // 4. 空列表
                    // ==================================================
                    "[] | []",

                    // ==================================================
                    // 5. 只有一个URL，没有重复前缀
                    // ==================================================
                    "/api/v1/users | []",

                    // ==================================================
                    // 6. 多个URL之间没有重复前缀
                    // ==================================================
                    "/a,/b,/c | []",

                    // ==================================================
                    // 7. 两个完全相同的多级URL
                    // ==================================================
                    // 两个前缀次数相同，较短的前缀字典序更小
                    "/a/b,/a/b | /a 2;/a/b 2",

                    // ==================================================
                    // 8. 只有第一层公共前缀重复
                    // ==================================================
                    "/a/b,/a/c,/a/d | /a 3",

                    // ==================================================
                    // 9. 不同出现次数按降序排列
                    // ==================================================
                    "/a/b,/a/b,/a/c,/a/d | /a 4;/a/b 2",

                    // ==================================================
                    // 10. 三个前缀同频，按字典序排列
                    // ==================================================
                    "/z,/z,/a,/a,/m,/m | /a 2;/m 2;/z 2",

                    // ==================================================
                    // 11. 一个URL可能是另一个URL的路径前缀
                    // ==================================================
                    "/a,/a/b,/a/b/c | /a 3;/a/b 2",

                    // ==================================================
                    // 12. 点号作为普通路径字符
                    // ==================================================
                    "/api.js,/api.js,/api/v1,/api/v1" +
                            " | /api 2;/api.js 2;/api/v1 2",

                    // ==================================================
                    // 13. 根路径与普通路径同频
                    // ==================================================
                    "/,/,/a,/a | / 2;/a 2",

                    // ==================================================
                    // 14. 普通URL不能派生出根路径
                    // ==================================================
                    "/,/a,/b | []",

                    // ==================================================
                    // 15. 多组前缀具有不同出现次数
                    // ==================================================
                    "/x/a,/x/a,/x/b,/x/c,/y,/y,/y | /x 4;/y 3;/x/a 2",

                    // ==================================================
                    // 16. 较深的公共路径
                    // ==================================================
                    "/a/b/c/d,/a/b/c/e | /a 2;/a/b 2;/a/b/c 2",

                    // ==================================================
                    // 17. 相似名称不能被当作同一个前缀
                    // ==================================================
                    "/api,/api2,/api,/api2 | /api 2;/api2 2",

                    // ==================================================
                    // 18. 点号出现在多级路径中
                    // ==================================================
                    "/static/app.js,/static/app.js,/static/app.css" +
                            " | /static 3;/static/app.js 2"
            },
            delimiter = '|'
    )
    void testProcessUrlExtract(String urlsStr, String expectedStr) {
        ArrayList<String> urls = parseUrls(urlsStr);
        ArrayList<String> expected = parseExpected(expectedStr);

        ArrayList<String> actual = solution.processUrlExtract(urls);

        assertEquals(expected, actual);
    }

    /**
     * 出现次数超过 Integer 缓存范围时，
     * 相同次数的路径仍然必须按字典序排列。
     */
    @Test
    void testEqualFrequencyAboveIntegerCache() {
        ArrayList<String> urls = new ArrayList<>();

        for (int i = 0; i < 128; i++) {
            urls.add("/b");
            urls.add("/a");
        }

        ArrayList<String> expected = new ArrayList<>(List.of(
                "/a 128",
                "/b 128"
        ));

        assertEquals(expected, solution.processUrlExtract(urls));
    }

    private ArrayList<String> parseUrls(String str) {
        if ("[]".equals(str.trim())) {
            return new ArrayList<>();
        }

        return new ArrayList<>(Arrays.asList(str.trim().split(",")));
    }

    private ArrayList<String> parseExpected(String str) {
        if ("[]".equals(str.trim())) {
            return new ArrayList<>();
        }

        ArrayList<String> result = new ArrayList<>();
        Collections.addAll(result, str.trim().split(";"));
        return result;
    }
}
