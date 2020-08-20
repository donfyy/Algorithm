package longestpalindromicsubstring

fun countSubstrings(s: String): Int {
    //f(i, j)表示s[i, j]是否是回文子串
    //f(i, j) = f(i + 1, j - 1) && s[i + 1] == s[j - 1]
    //i in [0, n - 1] j in [0, n - 1]
    var ret = 0
    val n = s.length
    val dp = BooleanArray(n)
    for (i in n - 1 downTo 0) {
        for (j in n - 1 downTo i) {
            dp[j] = s[i] == s[j] && (j - i < 2 || dp[j - 1])
            if (dp[j]) {
                ret++
            }
        }
    }
    return ret
}

class _647_Solution2_ {
    fun countSubstrings(s: String): Int {
        //0: 0 0,1: 0 1 ,2: 1 1,3: 1 2, 2n-2: n - 1 n - 1,
        val n = s.length
        var ret = 0
        for (i in 0..2 * (n - 1)) {
            var l = i shr 1
            var r = l + (i and 1)
            while (l >= 0 && r < n && s[l] == s[r]) {
                l--
                r++
                ret++
            }
        }
        return ret
    }
}