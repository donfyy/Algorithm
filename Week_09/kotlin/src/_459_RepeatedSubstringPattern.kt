fun repeatedSubstringPattern(s: String): Boolean {
    val n = s.length
    for (i in 1..(n ushr 1)) {
        if (n % i == 0) {
            var j = i
            while (j < n) {
                if (s[j] != s[j - i]) {
                    break
                }
                j++
            }
            if (j == n) {
                return true
            }
        }
    }
    return false
}

class _459_KMP_ {
    fun repeatedSubstringPattern(s: String): Boolean {
        val n = s.length
        val lps = IntArray(n)
        var i = 1
        var j = 0
        while (i < n) {
            when {
                s[j] == s[i] -> lps[i++] = ++j
                j != 0 -> j = lps[j - 1]
                else -> i++
            }
        }
        return j != 0 && n % (n - j) == 0
    }
}