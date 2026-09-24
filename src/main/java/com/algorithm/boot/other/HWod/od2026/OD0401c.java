package com.algorithm.boot.other.HWod.od2026;

/**
 * 华为 OD 机试题：勇攀数字高峰。
 * <p>
 * 给定一个 {@code n * m} 的二维整数数组表示海拔地图，数组中的每个数字
 * 表示对应位置的海拔高度。地图中最低海拔点和最高海拔点都只有一个。
 * 需要统计从最低海拔点出发，最终到达最高海拔点的合法登山路径数量。
 * <p>
 * 路径需要同时满足以下条件：
 * <ol>
 *     <li>每一步只能向上、下、左、右四个方向移动；</li>
 *     <li>移动后的海拔必须严格高于当前位置；</li>
 *     <li>每一步的海拔高度差必须大于 0，并且不超过指定的最大高度差；</li>
 *     <li>路径必须从地图中的唯一最低点开始，在唯一最高点结束；</li>
 *     <li>同一条路径中每个位置最多访问一次。</li>
 * </ol>
 * 由于路径上的海拔严格递增，因此已经访问过的位置实际上不会被再次到达。
 * <p>
 * 地图行数和列数的范围均为 {@code [2, 10]}。
 *
 * <h2>示例</h2>
 * <pre>
 * heightMap = [[1,2],[3,5]], maxHeightDifference = 2
 * </pre>
 * 最低点为 {@code (0,0)}，最高点为 {@code (1,1)}，唯一合法路径为：
 * <pre>
 * (0,0) -> (1,0) -> (1,1)
 * </pre>
 * 因此返回 {@code 1}。
 */
public class OD0401c {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static class Point {
        int x;
        int y;
        int height;

        Point(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }


    /**
     * 统计从唯一最低海拔点到唯一最高海拔点的合法登山路径数量。
     *
     * @param heightMap           海拔地图
     * @param maxHeightDifference 单步允许的最大海拔高度差
     * @return 满足条件的登山路径数量
     */
    public int countClimbingPaths(int[][] heightMap, int maxHeightDifference) {

        int m = heightMap.length;
        int n = heightMap[0].length;

        Point start = new Point(0, 0, heightMap[0][0]);
        Point end = new Point(0, 0, heightMap[0][0]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (heightMap[i][j] > end.height) {
                    end = new Point(i, j, heightMap[i][j]);
                }
                if (heightMap[i][j] < start.height) {
                    start = new Point(i, j, heightMap[i][j]);
                }
            }
        }

        return dfs(start, end, heightMap, maxHeightDifference);
    }

    private int dfs(Point curr, Point end, int[][] heightMap, int maxHeightDifference) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        if (curr.x == end.x && curr.y == end.y) {
            return 1;
        }
        int count = 0;
        for (int[] direction : DIRECTIONS) {
            int nextX = curr.x + direction[0];
            int nextY = curr.y + direction[1];
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                continue;
            }
            int nextHeight = heightMap[nextX][nextY];
            Point nextPoint = new Point(nextX, nextY, nextHeight);
            int heightDiff = nextPoint.height - curr.height;
            if (heightDiff > maxHeightDifference || heightDiff <= 0) {
                continue;
            }
            count += dfs(nextPoint, end, heightMap, maxHeightDifference);
        }

        return count;
    }
}
