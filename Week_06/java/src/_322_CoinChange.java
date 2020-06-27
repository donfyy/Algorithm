import java.util.Arrays;

/**
 * 第一遍：2020/06/27周六 ✅
 * 第二遍：2020/06/27周六
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 */
class _322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        //f(i) 凑成金额i所需的最少的硬币个数
        //f(i) = min(f(i - 1), f(i - 2), f(i - 5)) + 1
        //f(1) = 1
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];//[1] amount为0时应输出0
    }
    // TODO: 2020/6/27 贪心 
}