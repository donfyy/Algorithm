class _264_Dp {
    fun nthUglyNumber(n: Int): Int {
        if (n < 1) return 0
        val dp = IntArray(n).apply { this[0] = 1 }
        var p2 = 0
        var p3 = 0
        var p5 = 0
        for (i in 1 until n) {
            dp[i] = minOf(dp[p2] * 2, dp[p3] * 3, dp[p5] * 5)
            if (dp[p2] * 2 <= dp[i]) p2++
            if (dp[p3] * 3 <= dp[i]) p3++
            if (dp[p5] * 5 <= dp[i]) p5++
        }
        return dp.last()
    }
}