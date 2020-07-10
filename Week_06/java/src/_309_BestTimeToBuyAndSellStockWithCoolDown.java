/**
 * 第一遍：2020/07/10周五 ✅
 * 第二遍：2020/06/29周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 * 没有清楚地定义状态，没有想明白。。。
 */
class _309_BestTimeToBuyAndSellStockWithCoolDown {
    public int maxProfit(int[] prices) {
        //f(i)(0)第i天结束后持有股票的最大利润
        //f(i)(1)第i天结束后处于冷冻期最大利润
        //f(i)(2)第i天结束后不处于冷冻期也不持有股票最大利润
        //f(i)(0) = max(f(i-1)(2) - value(i), f(i-1)(0))
        //f(i)(1) = f(i-1)(0) + value(i)
        //f(i)(2) = max(f(i-1)(1), f(i)(2))
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int dp0 = -prices[0];
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int dp0_ = Math.max(dp2 - prices[i], dp0);
            int dp1_ = dp0 + prices[i];
            int dp2_ = Math.max(dp1, dp2);

            dp0 = dp0_;
            dp1 = dp1_;
            dp2 = dp2_;
        }
        return Math.max(dp1, dp2);
    }
}