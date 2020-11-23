#include <vector>
using namespace std;
class Solution
{
public:
    vector<int> countBits(int n)
    {
        // [0, n]每一个数的二进制位中1的个数
        // f(i) 表示i二进制位中1的个数
        // f(i) = f(i & i - 1) + 1
        // f(i) = f(i >> 1) + (i & 1)
        // 无后效性对于dp来说非常精辟
        // f(0) = 0
        vector<int> dp(n + 1);
        for (int i = 1; i <= n; i++)
        {
            dp[i] = dp[i >> 1] + (i & 1);
            // dp[i] = dp[i & i - 1] + 1;
        }
        return dp;
    }
};