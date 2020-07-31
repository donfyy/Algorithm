package besttimetobuyandsellstock;
/**
 * 第一遍：2020/07/30周四 ✅
 * 第二遍：2020/07/30周五 ✅
 * 第三遍：2020/07/29周三
 * 第四遍：2020/07/05周日
 */
class _122_BestTimeToBuyAndSellStockII {
    /**
     * 贪心算法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        } 
        
        int ret = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            ret += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ret;
    }
}