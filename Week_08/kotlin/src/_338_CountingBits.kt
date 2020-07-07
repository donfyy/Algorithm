fun countBits(num: Int): IntArray {
    if (num < 0) return IntArray(0)
    val dp = IntArray(num + 1)
    for (i in 1..num) {
        dp[i] = dp[i and (i - 1)] + 1
    }
    return dp
}