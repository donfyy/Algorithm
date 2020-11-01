public class _463_IslandPerimeter {
    class Solution {
        public int islandPerimeter(int[][] grid) {
            // 要计算岛屿的周长
            // 就要计算每个陆地对周长的贡献
            // 对于每一条左侧与上侧的边，都有一条右侧与下侧的边与之对称
            // 因此统计从左到右与从上到下第一次遇到的陆地数，该陆地数乘2即为周长
            if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
            final int m = grid.length, n = grid[0].length;
            int ret = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        ret += j == 0 || grid[i][j - 1] == 0 ? 1 : 0;
                        ret += i == 0 || grid[i - 1][j] == 0 ? 1 : 0;
                    }
                }
            }
            return ret << 1;
        }
    }
}
