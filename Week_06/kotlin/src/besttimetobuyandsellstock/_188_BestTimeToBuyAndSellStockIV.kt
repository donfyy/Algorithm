package besttimetobuyandsellstock

class _188_BestTimeToBuyAndSellStockIV_ {
    class Solution {
        fun maxProfit(k_: Int, prices: IntArray): Int {
            // f(s, i, k) 表示第i天结束时，已经完成了k笔交易，股票状态为s时的最大利润
            // f(1, i, k) = max(f(1, i - 1, k), -prices[i] + f(0, i - 1, k))
            // f(0, i, k) = max(f(0, i - 1, k), prices[i] + f(1, i - 1, k - 1))
            // 存在无效状态，因为求最大值，所以都初始化为一个最小值
            // 考虑到无效状态存在减法运算，因此不能将无效状态初始化为最小值，否则可能负数溢出
            // f(0, 0, 0) = 0 f(1, 0, 0) = -prices[0]
            // 最大利润：第i天结束后，股票状态为0时，完成了 j in [0, k] 笔交易的最大值
            // 交易次数上限与天数n有关，为n/2
            // 优化空间复杂度
            val n = prices.size
            if (n == 0) return 0
            val k = minOf(k_, n shr 1) + 1
            val dp = Array(2) { IntArray(k) { Int.MIN_VALUE shr 1 } }
            dp[0][0] = 0
            dp[1][0] = -prices[0]
            for (i in 1 until n) {
                for (j in 0 until k) {
                    dp[1][j] = maxOf(dp[1][j], dp[0][j] - prices[i])
                    if (j > 0) {
                        dp[0][j] = maxOf(dp[0][j], dp[1][j - 1] + prices[i])
                    }
                }
            }
            return dp[0].max()!!
        }
    }
}