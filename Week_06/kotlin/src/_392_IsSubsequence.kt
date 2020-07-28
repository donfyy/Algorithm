fun isSubsequence(s: String, t: String): Boolean {
    var i = 0
    var j = 0
    val m = s.length
    val n = t.length
    while (i < n && j < m) {
        if (t[i] == s[j]) {
            j++;
        }
        i++;
    }
    return j == m
}

fun isSubsequenceWithPreprocessing(s: String, t: String): Boolean {
    //我们用了大量的时间在t中查找s中某个字符出现的位置，那么能不能加速这一过程
    //也就是在t中每一个位置存储每一个字符下一次在t中出现的位置，也就是建立索引。
    //f(i,j)表示t中从i开始包含i往后字符j第一次出现的位置
    //如果j == t[i] f(i,j) = i 否则 f(i, j) = f(i + 1,j)
    //i in [0, t.length - 1] 边界是f(t.length - 1, j) = t.length
    val n = t.length
    val dp = Array(n + 1) { IntArray(26) }
    for (j in 0..25) {
        dp[n][j] = n
    }
    for (i in n - 1 downTo 0) {
        for (j in 0..25) {
            if (t[i] - 'a' == j) {
                dp[i][j] = i
            } else {
                dp[i][j] = dp[i + 1][j]
            }
        }
    }

    var i = 0
    for (c in s) {
        val idx = dp[i][c - 'a']
        if (idx == n) {
            return false
        }
        i = idx + 1
    }
    return true
}