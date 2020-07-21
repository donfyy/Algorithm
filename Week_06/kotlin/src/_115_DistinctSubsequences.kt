fun numDistinct(s: String, t: String): Int {
    //f(i, j)表示t[0, i - 1]在s[0, j - 1]的子序列中出现的个数
    //if(t[i - 1] != s[i - 1]) f(i, j) = f(i, j - 1)
    //else f(i, j) = f(i - 1, j - 1) + f(i, j - 1)
    //没想明白为什么要 f(i - 1, j - 1) + f(i, j - 1)
    val m = t.length
    val n = s.length
    val dp = Array(m + 1) { IntArray(n + 1) }
    for (j in 0..n) {
        dp[0][j] = 1
    }
    for (i in 1..m) {
        for (j in 1..n) {
            if (t[i - 1] == s[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1]
            } else {
                dp[i][j] = dp[i][j - 1]
            }
        }
    }
    return dp[m][n]
}