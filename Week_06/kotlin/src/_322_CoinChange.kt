fun coinChange(coins: IntArray, amount: Int): Int {
    //f(i) 凑成总金额i所需的最少的硬币个数
    //f(i) = min(f(i - 1), f(i - 2), f(i - 5)) + 1
    if (coins.isEmpty()) return -1
    val dp = IntArray(amount + 1) { amount + 1 }
    dp[0] = 0
    for (coin in coins) {
        for (i in 1..amount) {
            if (coin <= i) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1)
            }
        }
    }
    return if (dp[amount] > amount) -1 else dp[amount]
}

fun main() {
    println(coinChange(intArrayOf(1, 2, 5), 11))
}

class UsingDfs {
    // 优先使用面值大的硬币 O(mn) O(n)
    fun coinChange(coins: IntArray, amount: Int): Int {
        coins.apply {
            sort()
            reverse()
        }
        var ret = amount + 1
        fun dfs(idx: Int, remain: Int, cnt: Int) {
            if (remain == 0) {
                ret = minOf(ret, cnt)
                return
            }
            if (idx == coins.size) return
            var coinsCnt = remain / coins[idx]
            while (coinsCnt >= 0 && cnt + coinsCnt < ret) {
                dfs(idx + 1, remain - coinsCnt * coins[idx], cnt + coinsCnt)
                coinsCnt--
            }
        }
        dfs(0, amount, 0)
        return ret
    }
}