fun minDistance(word1: String, word2: String): Int {
    //f(i, j)表示word1前i个字符转换成word2前j个字符所使用的最少操作数
    //if (word1[i] == word2[j]) f(i,j) = f(i - 1, j - 1)
    //else f(i, j) = min(f(i - 1, j), f(i, j - 1), f(i - 1, j - 1)) + 1
    // 1 <= i <= m    1 <= j <= m
    //if (i == 0) f(0, j) = j
    //if (j == 0) f(i, 0) = i
    val m = word1.length
    val n = word2.length
    val dp = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
        dp[i][0] = i
    }
    for (j in 1..n) {
        dp[0][j] = j
    }
    for (i in 1..m) {
        for (j in 1..n) {
            if (word1[i - 1] == word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1
            }
        }
    }
    return dp[m][n]
}