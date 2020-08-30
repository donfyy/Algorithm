fun shortestPalindrome(s: String): String {
    val r = StringBuilder(s).reverse()
    for (i in s.indices) {
        if (s.startsWith(r.substring(i))) {
            return r.substring(0, i) + s
        }
    }
    return ""
}

private const val D = 256
private const val Q = 1000000007

class _214_RabinKarp {
    fun shortestPalindrome(s: String): String {
        var l = 0L
        var r = 0L
        var m = 1L
        var rMax = 0
        for (i in s.indices) {
            l = (l * D + s[i].toLong()) % Q
            r = (s[i].toLong() * m + r) % Q
            m = m * D % Q
            if (l == r) rMax = i
        }
        val sb = StringBuilder()
        for (i in s.lastIndex downTo rMax + 1) {
            sb.append(s[i])
        }
        return sb.append(s).toString()
    }
}

class _214_KMP {
    fun shortestPalindrome(s: String): String {
        val n = s.length
        val lps = IntArray(n + 1).apply { this[0] = -1 }
        var j = 0
        var i = 1
        while (i < n) {
            when {
                s[i] == s[j] -> lps[++i] = ++j
                j > 0 -> j = lps[j]
                else -> i++
            }
        }

        i = n - 1
        j = 0
        while (i >= 0) {
            when {
                s[i] == s[j] -> {
                    i--;j++
                }
                j > 0 -> j = lps[j]
                else -> i--
            }
        }

        val sb = StringBuilder()
        i = n - 1
        while (i >= j) {
            sb.append(s[i--])
        }
        sb.append(s)
        return sb.toString()
    }
}