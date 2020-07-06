/**
 * 第一遍：2020/06/22周一 ✅
 * 第二遍：2020/06/23周二 ✅
 * 第三遍：2020/07/06周一 ✅
 * 第四遍：2020/07/05周日
 */
class _63_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int cols = obstacleGrid[0].length;
        int[] dp = new int[cols];//状态表示？
        dp[0] = 1;//边界情况，递推的起点
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < cols; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j != 0) {
                    dp[j] += dp[j - 1];//状态转移
                }
            }
        }
        return dp[cols - 1];
    }
}