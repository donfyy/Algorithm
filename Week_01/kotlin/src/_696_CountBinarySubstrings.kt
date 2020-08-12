fun countBinarySubstrings(s: String): Int {
    var pre = 0
    var curr = 1
    var ret = 0
    for (i in 1 until s.length) {
        if (s[i] == s[i - 1]) {
            curr++
        } else {
            ret += minOf(pre, curr)
            pre = curr
            curr = 1
        }
    }
    return ret + minOf(pre, curr)
}