fun maxCoins(nums: IntArray): Int {
    //最终状态：(0, n + 2)之间的[1, n]气球都被戳破
    //如何达到最终状态：在(0..n)之间选择任意一个气球k戳破
    //k未被戳破之前的状态(0..k)与(k, n)两个区间的气球都被戳破了
    //状态表示：f(i, j)表示(i, j)之间的气球都被戳破时能够获得硬币的最大数量
    //状态转移：f(i, j) = max(v[k] * v[i]* v[j] + f(i, k) + f(k, j))
    //边界条件：if (i >= j - 1) f(i, j) = 0
    // 0 <= i <= n - 1    2 <= j <= n + 1
    val n = nums.size
    val nums1 = IntArray(n + 2)
    System.arraycopy(nums, 0, nums1, 1, n)
    nums1[0] = 1
    nums1[n + 1] = 1
    val dp = Array(n + 2){IntArray(n + 2)}
    for (i in n - 1 downTo 0) {
        for (j in i + 2 until n + 2) {
            for (k in i + 1 until j) {
                dp[i][j] = Math.max(dp[i][j], dp[i][k] + nums1[i] * nums1[k] * nums1[j] + dp[k][j])
            }
        }
    }
    return dp[0][n + 1]
}