fun minPathSum(grid: Array<IntArray>): Int {
    //f(i, j)表示到达i,j位置时路径上的最小数字总和
    //f(i, j) = min(f(i - 1, j), f(i, j - 1)) + value(i, j)
    //i in [0, m - 1] j in [0, n - 1]
    //i == 0 f(0, j) = f(0, j - 1) + value(0, j)
    //j == 0 f(i, 0) = f(i - 1, 0) + value(i, 0)
    //f(0, 0) = value(0, 0)
    if (grid.isEmpty() || grid[0].isEmpty()) return -1;
    val m = grid.size
    val n = grid[0].size
    val dp = IntArray(n)
    dp[0] = grid[0][0]
    for (j in 1 until n) {
        dp[j] = dp[j - 1] + grid[0][j]
    }
    for (i in 1 until m) {
        dp[0] += grid[i][0]
        for (j in 1 until n) {
            dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j]
        }
    }
    return dp[n - 1]
}