fun countBinarySubstrings(s: String): Int {
    var pre = 0
    var ret = 0
    var count = 1
    for (i in 1 until s.length) {
        if (s[i] == s[i - 1]) {
            count++
        } else {
            ret += minOf(pre, count)
            pre = count
            count = 1
        }
    }
    return ret + minOf(pre, count)
}