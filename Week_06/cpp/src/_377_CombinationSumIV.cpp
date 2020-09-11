#include <vector>
#include <iostream>

using namespace std;

class Solution
{
public:
    int combinationSum4(vector<int> &nums, int target)
    {
        // f(i) 表示和为i的组合的个数
        // f(i) = f(i - 1) + f(i - 2) + ... + f(i - j) for j in nums
        // 记k为nums中最小的数,则f(k) = f(k - k) = f(0) = 1
        vector<unsigned long long> dp(target + 1);
        dp[0] = 1;
        for (int i = 1; i <= target; i++)
        {
            for (int num : nums)
            {
                if (i >= num)
                {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
};