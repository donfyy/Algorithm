//空间优化从O(mn)到O(n)需要注意边界条件。
fun isMatch(s: String, p: String): Boolean {
    //f(i, j)表示s前i个字符和p前j个字符是否匹配
    //if (p[j] == '*') f(i, j) = f(i - 1, j) || f(i, j - 1)
    //if (p[j] == '?' || p[j] == s[i]) f(i, j) = f(i - 1, j - 1)
    //f(i, j) = false
    //s = ""  f(0, j) = true if (p[j] == '*')
    //f(0, 0) = true
    val m = s.length
    val n = p.length
    val dp = BooleanArray(n + 1)
    dp[0] = true//1
    for (j in 1..n) {
        if (p[j - 1] == '*') {
            dp[j] = true
        } else {
            break;
        }
    }
    for (i in 1..m) {
        var leftTop = i == 1
        dp[0] = false//2
        for (j in 1..n) {
            val top = dp[j]
            if (p[j - 1] == '*') {
                dp[j] = top || dp[j - 1]
            } else if (p[j - 1] == '?' || p[j - 1] == s[i - 1]) {
                dp[j] = leftTop
            } else {
                dp[j] = false//3
            }
            leftTop = top
        }
    }
    return dp[n]
}