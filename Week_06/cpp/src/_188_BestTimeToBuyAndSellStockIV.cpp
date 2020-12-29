#include <vector>
using namespace std;
class Solution
{
public:
    // 需要注意六个点 O(n*min(n, k)) O(min(n, k))
    int maxProfit(int k, vector<int> &prices)
    {
        const int n = prices.size();
        if (!n)
            return 0;
        k = min(k, n >> 1) + 1;
        vector<vector<int>> dp(2, vector<int>(k, INT_MIN >> 1));
        dp[0][0] = 0;
        dp[1][0] = -prices[0];
        for (int i = 1; i < n; i++)
        {
            dp[1][0] = max(dp[1][0], dp[0][0] - prices[i]);
            for (int j = 1; j < k; j++)
            {
                dp[1][j] = max(dp[1][j], dp[0][j] - prices[i]);
                dp[0][j] = max(dp[0][j], dp[1][j - 1] + prices[i]);
            }
        }
        return *max_element(dp[0].begin(), dp[0].end());
    }
};