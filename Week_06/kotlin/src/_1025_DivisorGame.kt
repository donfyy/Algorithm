fun divisorGame(N: Int): Boolean {
    // return (N and 1) == 0
    // f(i) 表示 对于给定的数字i Alice先手是处于必胜态还是必败态
    // f(i) = f(i - j) for j and i % j == 0 in (0, i)
    // f(1) = false f(2) = true ,i in [3, i]
    if (N < 2) return false
    val dp = BooleanArray(N + 1)
    dp[1] = false
    dp[2] = true
    for (i in 3..N) {
        for (j in 1..(i ushr 1)) {
            if (i % j == 0 && !dp[i - j]) {
                dp[i] = true
                break
            }
        }
    }
    return dp[N]
}