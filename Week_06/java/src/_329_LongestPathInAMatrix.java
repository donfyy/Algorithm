import java.util.LinkedList;
import java.util.Queue;

/**
 * 第一遍：2020/07/27周一 ✅
 * 第二遍：2020/07/26周日
 * 第三遍：2020/07/27周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 */
class _329_LongestPathInAMatrix {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        //每个单元格都对应一个最长递增路径的长度，并且该长度是固定不变的
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret = Math.max(ret, dfs(matrix, i, j, memo));
            }
        }
        return ret;
    }

    int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        memo[i][j]++;
        for (int[] dir : dirs) {
            int in = i + dir[0];
            int jn = j + dir[1];

            if (in >= 0 && in < matrix.length && jn >= 0 && jn < matrix[0].length && matrix[in][jn] > matrix[i][j]) {
                memo[i][j] = Math.max(memo[i][j], dfs(matrix, in, jn, memo) + 1);
            }
        }
        return memo[i][j];
    }

    class SolutionWithDP {
        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }

            int m = matrix.length;
            int n = matrix[0].length;
            int[][] outDegrees = new int[m][n];
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : dirs) {
                        int in = i + dir[0];
                        int jn = j + dir[1];
                        if (in >= 0 && in < m && jn >= 0 && jn < n && matrix[in][jn] > matrix[i][j]) {
                            outDegrees[i][j]++;
                        }
                    }
                }
            }

            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (outDegrees[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                    }
                }
            }

            int level = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int[] cell = queue.poll();
                    int i = cell[0];
                    int j = cell[1];
                    for (int[] dir : dirs) {
                        int in = i + dir[0];
                        int jn = j + dir[1];
                        if (in >= 0 && in < m && jn >= 0 && jn < n && matrix[in][jn] < matrix[i][j]) {
                            outDegrees[in][jn]--;
                            if (outDegrees[in][jn] == 0) {
                                queue.offer(new int[]{in, jn});
                            }
                        }
                    }
                }
                level++;
            }
            return level;
        }
    }
}