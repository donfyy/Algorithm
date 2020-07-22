/**
 * 第一遍：2020/07/23周一 ✅
 * 第二遍：2020/06/15周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 * 一遍过呀
 */
public class _64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        //f(i, j)表示到达(i, j)时最小的数字总和
        //f(i, j) = min(f(i, j - 1), f(i - 1, j)) + v(i, j)
        // 0 <= i < m    0 <= j < n
        // dp[0][0] = grid[0][0]
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
