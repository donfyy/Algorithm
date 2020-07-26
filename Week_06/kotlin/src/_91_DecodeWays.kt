fun numDecodings(s: String): Int {
    //f(i)前i个字符的解码方法数
    //if (s[i - 1] == '0') if (s[i - 2] == '1' || s[i - 2] == '2') f(i) = f(i - 2) else f(i) =  0
    //else if (s[i - 2] == '1' || (s[i - 2] == '2' && s[i - 1] <= '6')) f(i) = f(i - 1) + f(i - 2) else f(i) = f(i - 1)
    //i in [1, s.size] f(0) = 1 f(1) = 1
    //if (s[0] == '0') return 0
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
    return left;
}