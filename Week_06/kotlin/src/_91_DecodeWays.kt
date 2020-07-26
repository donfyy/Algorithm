fun numDecodings(s: String): Int {
    //f(i) 表示 前i个字符的解码方法总数
    //如果s[i - 1]在[1, 9]之间则f(i) = f(i - 1)
    //如果s[i - 2, i - 1]在[10, 26]之间 f(i) += f(i - 2)
    //f(0) = 1, f(1) = 1 i in [2, s.length]  s[0] == 0 f(i) = 0
    if (s.isEmpty() || s[0] == '0') return 0
    var leftPreceding = 1
    var left = 1
    for (i in 2..s.length) {
        val first = s[i - 1] - '0'
        val second = (s[i - 2] - '0') * 10 + first
        var dp = 0
        if (first in 1..9) {
            dp = left
        }
        if (second in 10..26) {
            dp += leftPreceding
        }
        leftPreceding = left
        left = dp
    }
    return left
}