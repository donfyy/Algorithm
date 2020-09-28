import java.util.Arrays;

public class _322_CoinChange {
    static class UsingGreedy {
        int ret;

        public int coinChange(int[] coins, int amount) {
            if (coins == null) return -1;
            Arrays.sort(coins);
            ret = amount + 1;
            dfs(coins, coins.length - 1, amount, 0);
            return ret > amount ? -1 : ret;
        }

        void dfs(int[] coins, int idx, int amount, int cnt) {
            if (amount == 0) {
                ret = Math.min(ret, cnt);
                return;
            }
            if (idx < 0) return;
            for (int availCnt = amount / coins[idx]; availCnt >= 0 && cnt + availCnt < ret; availCnt--) {
                dfs(coins, idx - 1, amount - availCnt * coins[idx], cnt + availCnt);
            }
        }
    }
}
