//这里是一个错误示范。。。
fun uniquePathsWithObstacles_fail(obstacleGrid: Array<IntArray>): Int {
    //f(i, j)走到i,j的路径数量
    //f(i, j) = f(i - 1, j) + f(i, j - 1)
    if (obstacleGrid.isEmpty() || obstacleGrid[0].isEmpty()) return 0
    if (obstacleGrid[0][0] == 1) return 0
    val m = obstacleGrid.size
    val n = obstacleGrid[0].size
    val dp = IntArray(n + 1)
    dp[0] = 1
    for (i in 1..m) {
        for (j in 1..n) {
            if (obstacleGrid[i - 1][j - 1] == 0)
                dp[j] = dp[j - 1] + dp[j]
            else
                dp[j] = 0
        }
    }
    return dp[n]
}

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    //f(i, j)走到i,j的路径数量
    //f(i, j) = f(i - 1, j) + f(i, j - 1)
    if (obstacleGrid.isEmpty() || obstacleGrid[0].isEmpty()) return 0
    if (obstacleGrid[0][0] == 1) return 0
    val m = obstacleGrid.size
    val n = obstacleGrid[0].size
    val dp = IntArray(n)
    dp[0] = 1
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (obstacleGrid[i][j] == 1) {
                dp[j] = 0
            } else if (j > 0) {
                dp[j] += dp[j - 1]
            }
        }
    }
    return dp[n - 1]
}