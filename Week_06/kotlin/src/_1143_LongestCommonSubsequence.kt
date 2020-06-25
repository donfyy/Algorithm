/*dp[i][j]表示text1到第i个字符为止的字符串与text2到第j个字符为止的字符串的最长公共子序列的长度
//dp[i][j] = dp[i - 1][j - 1] + 1
//dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])*/
fun longestCommonSubsequence(text1: String, text2: String): Int {
//    Error:(21, 5) Kotlin: Expecting an element 之前kotlin总在第一行报这个错误，好像是换行符的问题
    val m = text1.length
    val n = text2.length
    val dp = Array(m + 1) {IntArray(n + 1)}
    for (i in 1..m) {
        val c = text1[i - 1]
        for (j in 1..n) {
            if (c == text2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    return dp[m][n]
}

//时间O(m*n)空间O(min(m,n))
fun longestCommonSubsequence1(text1: String, text2: String): Int {
    val m = text1.length
    val n = text2.length
    if (m < n) return longestCommonSubsequence1(text2, text1)
    val dp = Array(2) {IntArray(n + 1)}
    var k = 1
    for (i in 1..m) {
        val c = text1[i - 1]
        for (j in 1..n) {
            dp[k][j] = if (c == text2[j - 1]) dp[k xor 1][j - 1] + 1 else Math.max(dp[k xor 1][j], dp[k][j - 1])
        }
        k = k xor 1
    }
    return dp[m and 1][n]
}

//时间O(m*n)空间O(min(m,n))
fun longestCommonSubsequence2(text1: String, text2: String): Int {
    val m = text1.length
    val n = text2.length
    if (m < n) return longestCommonSubsequence2(text2, text1)
    val dp = IntArray(n + 1)
    for (i in 1..m) {
        var dpi_1j_1 = 0
        var dpi_1j = dp[1]
        val c = text1[i - 1]
        for (j in 1..n) {
            dp[j] = if (c == text2[j - 1]) dpi_1j_1 + 1 else Math.max(dp[j - 1], dpi_1j)
            dpi_1j_1 = dpi_1j
            if (j != n) dpi_1j = dp[j + 1]
        }
    }
    return dp[n]
}