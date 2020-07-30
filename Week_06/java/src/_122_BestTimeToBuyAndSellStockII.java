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