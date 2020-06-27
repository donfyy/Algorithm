fun minimumTotal(triangle: List<List<Int>>): Int {
    //f(i,j)表示到达i层第j个节点的最小路径和
    //f(i,j) = min(f(i+1,j), f(i+1,j+1)) + value(i, j)
    //从叶子节点开始
    val n = triangle.size
    val dp = IntArray(n + 1)
    for (i in n - 1 downTo 0) {
        val list = triangle[i]
        for (j in list.indices) {
            dp[j] = Math.min(dp[j], dp[j + 1]) + list[j]
        }
    }
    return dp[0]
}
