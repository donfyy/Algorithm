package besttimetobuyandsellstock

fun maxProfitDp(prices: IntArray): Int {
    //f(i)(0)表示第i天未持有股票的最大利润
    //f(i)(1)表示第i天持有股票的最大利润
    //f(i)(0) = Math.max(f(i - 1)(0), f(i - 1)(1) + prices[i])
    //f(i)(1) = Math.max(f(i - 1)(1),  - prices[i])
    //f(0)(0) = 0, f(0)(1) = Integer.MIN_VALUE
    if (prices.size < 2) {
        return 0
    }
    val n = prices.size
    val dp = Array(n) { IntArray(2) }
    dp[0][0] = 0
    dp[0][1] = -prices[0]
    for (i in 1 until n) {
        dp[i][0] = dp[i - 1][0].coerceAtLeast(dp[i - 1][1] + prices[i])
        dp[i][1] = dp[i - 1][1].coerceAtLeast(-prices[i])
    }
    return dp[n - 1][0].coerceAtLeast(dp[n - 1][1])
}

fun maxProfit(prices: IntArray): Int {
    //f(i)表示第i天卖出股票时可以获得的最大利润
    //记录i天之前股票的最低价格
    //f(0) = 0 f(1) = prices[1] - minPrices
    if (prices.size < 2) {
        return 0
    }
    var maxProfit = 0
    var minPrice = prices[0]
    for (i in 1 until prices.size) {
        maxProfit = maxProfit.coerceAtLeast(prices[i] - minPrice)
        minPrice = minPrice.coerceAtMost(prices[i])
    }
    return maxProfit
}

fun maxProfit2(prices: IntArray): Int {
    //f(i)表示到第i天可以获得的最大利润(大于0的),不是从第0天开始，而是从j天开始，类似子数组的最大值
    //f(i) = max(0,f(i - 1) + prices[i] - prices[i - 1])
    //f(0) = 0
    if (prices.size < 2) {
        return 0
    }
    var maxProfit = 0
    var profit = 0
    for (i in 1 until prices.size) {
        profit = 0.coerceAtLeast(profit + prices[i] - prices[i - 1])
        maxProfit = maxProfit.coerceAtLeast(profit)
    }
    return maxProfit
}