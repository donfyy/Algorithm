#include <vector>
using namespace std;
class UsingDp
{
public:
    // O(mn) O(n)
    int coinChange(vector<int> &coins, int n)
    {
        // f(x) 凑成x所需的最少硬币个数
        // f(x) = min(f(x - 1), f(x - 2), f(x - 5)) + 1
        // f(x) = amount + 1
        // f(0) = 0 x in [1, amount]
        vector<int> dp(n + 1, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++)
        {
            for (int coin : coins)
            {
                if (i >= coin)
                {
                    dp[i] = min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[n] > n ? -1 : dp[n];
    }
};
class UsingGreedyDfs
{
public:
    int ret;
    // O(mn) O(n)
    int coinChange(vector<int> &coins, int amount)
    {
        sort(coins.rbegin(), coins.rend());
        ret = amount + 1;
        dfs(coins, 0, amount, 0);
        return ret == amount + 1 ? -1 : ret;
    }
    void dfs(vector<int> &coins, int idx, int amount, int cnt)
    {
        if (amount == 0)
        {
            ret = min(ret, cnt);
            return;
        }
        if (idx == coins.size())
            return;
        for (int i = amount / coins[idx]; i >= 0 && cnt + i < ret; i--)
        {
            dfs(coins, idx + 1, amount - i * coins[idx], cnt + i);
        }
    }
};