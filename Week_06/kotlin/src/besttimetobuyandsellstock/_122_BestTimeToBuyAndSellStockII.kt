package besttimetobuyandsellstock

class _122_BestTimeToBuyAndSellStockII_ {
    fun maxProfit(prices: IntArray): Int {
        //f(i)(0)表示第i天未持有股票的最大利润
        //f(i)(1)表示第i天持有股票的最大利润
        //f(i)(0) = Math.max(f(i - 1)(0), f(i - 1)(1) + prices[i])
        //f(i)(1) = Math.max(f(i - 1)(1), f(i - 1)(0) - prices[i])
        //f(0)(0) = 0, f(0)(1) = -prices[0]
        if (prices.size < 2) {
            return 0
        }
        val n = prices.size
        val dp = Array(n) { IntArray(2) }
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        for (i in 1 until n) {
            dp[i][0] = dp[i - 1][0].coerceAtLeast(dp[i - 1][1] + prices[i])
            dp[i][1] = dp[i - 1][1].coerceAtLeast(dp[i - 1][0] - prices[i])
        }
        return dp[n - 1][0].coerceAtLeast(dp[n - 1][1])
    }

    fun maxProfitGreedy(prices: IntArray): Int {
        //f(i)(0)表示第i天未持有股票的最大利润
        //f(i)(1)表示第i天持有股票的最大利润
        //f(i)(0) = Math.max(f(i - 1)(0), f(i - 1)(1) + prices[i])
        //f(i)(1) = Math.max(f(i - 1)(1), f(i - 1)(0) - prices[i])
        //f(0)(0) = 0, f(0)(1) = -prices[0]
        if (prices.size < 2) {
            return 0
        }
        val n = prices.size
        var ret = 0
        for (i in 1 until n) {
            ret += 0.coerceAtLeast(prices[i] - prices[i - 1])
        }
        return ret
    }
}