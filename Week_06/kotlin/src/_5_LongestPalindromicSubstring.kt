fun longestPalindrome(s: String): String {
    //f(i,j)表示s[i, j]是否是一个回文子串
    //f(i,j) = f(i + 1, j - 1) && s[i] == s[j]
    //if (i == j) f(i,j) = true
    //0 <= i <= n - 1   0 <= j <= n - 1
    if (s.isEmpty()) return s
    val n = s.length
    val dp = Array(n) { BooleanArray(n) }
    var l = 0
    var r = 0
    for (i in n - 1 downTo 0) {
        for (j in n - 1 downTo i) {
            dp[i][j] = s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1])
            if (dp[i][j] && j - i > r - l) {
                l = i
                r = j
            }
        }
    }
    return s.substring(l, r + 1)
}

fun longestPalindrome1(s: String): String {
    if (s.isEmpty()) return s
    var l = 0
    var r = 1 //exclusive
    for (i in s.indices) {
        var len = expandPalindrome(s, i, i)
        val len1 = expandPalindrome(s, i, i + 1)
        len = Math.max(len, len1)
        if (len > r - l) {
            l = i - ((len - 1) shr 1)
            r = i + (len shr 1) + 1
            // r = len + l
        }
    }
    return s.substring(l, r)
}

fun expandPalindrome(s: String, left: Int, right: Int): Int {
    var l = left
    var r = right
    while (l >= 0 && r < s.length && s[l] == s[r]) {
        l--;
        r++;
    }
    return r - l - 1
}