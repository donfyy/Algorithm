fun integerBreak(n: Int): Int {
    //f(i)表示整数i拆分后可以获得的最大乘积
    //f(i) = Math.max(k * (i - k), k * f(i - k))  k in [1, i - 1]
    //f(2) = Math.max(1 * (2 - 1), 1 * f(1))  因此f(1) = 0
    if (n < 2) {
        return 0
    }
    val dp = IntArray(n + 1)
    for (i in 2..n) {
        for (k in 1..i) {
            dp[i] = (k * (i - k)).coerceAtLeast(k * dp[i - k]).coerceAtLeast(dp[i])
        }
    }
    return dp[n]
}
fun integerBreakGreedy(n: Int): Int {
    //n >= 5      2(n - 2) > n     3(n - 3) > n
    //3(n - 3) > 2(n - 2)
    //n = 4 2*2 > 1*3
    if (n < 4) {
        return n - 1
    }
    val quotient = (n / 3).toDouble()
    return when (n % 3) {
        0 -> {
            Math.pow(3.0, quotient).toInt()
        }
        1 -> {
            (Math.pow(3.0, quotient - 1) * 4).toInt()
        }
        else -> {
            (Math.pow(3.0, quotient) * 2).toInt()
        }
    }
}