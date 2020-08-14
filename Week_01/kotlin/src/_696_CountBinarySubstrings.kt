fun countBinarySubstrings(s: String): Int {
    var pre = 0 //前一段0或1的连续子串的长度
    var curr = 1 //当前0或1的连续子串的长度
    var ret = 0 // 符合条件的子字符串的数量
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