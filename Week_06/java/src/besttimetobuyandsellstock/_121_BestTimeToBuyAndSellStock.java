package besttimetobuyandsellstock;

/**
 * 第一遍：2020/07/30周四 ✅
 * 第二遍：2020/07/30周五 ✅
 * 第三遍：2020/07/29周三
 * 第四遍：2020/07/05周日
 */
class _121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        //f(i)表示第i天卖出时可能获得的最大利润
        //卖出价固定，买入价越低越好，在扫描到第i天时我们记录前i-1天中的最低价格
        //i in [1, n - 1] f(0) = 0
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxDiff = 0;
        int n = prices.length;
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            int currDiff = prices[i] - minPrice;
            if (currDiff > maxDiff) {
                maxDiff = currDiff;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return maxDiff;
    }

    class SolutionDp {
        public int maxProfit(int[] prices) {
            //f(i)表示第i天可能获得的最大利润
            //f(i) = f(i - 1) + prices[i] - prices[i - 1]
            //i in [1, n - 1] f(0) = 0
            if (prices == null || prices.length < 2) {
                return 0;
            }
            int dp = 0;
            int n = prices.length;
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                int currDiff = prices[i] - prices[i - 1];
                dp = Math.max(0, dp + currDiff);

                if (dp > maxProfit) {
                    maxProfit = dp;
                }
            }
            return maxProfit;
        }
    }
}