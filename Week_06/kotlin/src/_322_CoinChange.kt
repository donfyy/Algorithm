fun coinChange(coins: IntArray, amount: Int): Int {
    //f(i) 凑成总金额i所需的最少的硬币个数
    //f(i) = min(f(i - 1), f(i - 2), f(i - 5)) + 1
    if (coins.isEmpty()) return -1
    val dp = IntArray(amount + 1){amount + 1}
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