class _1024_VideoStitching_ {
    class Dp {
        fun videoStitching(clips: Array<IntArray>, T: Int): Int {
            // f(i) 覆盖片段[0, i]所需片段的最小数目
            // 对于任意一个区间[aj, bj] 如果 i > aj && i <= bj 表示[aj, bj]可以拼接成[0, i]
            // f(i) = f(aj) + 1, 因为aj有多个 所以 f(i) = min(f(aj) + 1)
            // 因为要求最小值，可以将f初始化为一个大整数
            // 考虑边界f(0) = 0
            // O(T * N) O(T)
            val dp = IntArray(T + 1) { Integer.MAX_VALUE - 1 }
            dp[0] = 0
            for (i in 1..T) {
                clips.forEach { (l, r) ->
                    if (i in (l + 1)..r) {
                        dp[i] = minOf(dp[i], dp[l] + 1)
                    }
                }
            }
            return if (dp[T] == Integer.MAX_VALUE - 1) -1 else dp[T]
        }
    }
}