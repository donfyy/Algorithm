#include <vector>
using namespace std;
// 1.2020/10/11
class Solution
{
public:
    bool canPartition(vector<int> &nums)
    {
        int n = nums.size();
        if (n < 2)
            return false;
        int sum = 0, maxNum = 0;
        for (int num : nums)
        {
            sum += num;
            maxNum = max(maxNum, num);
        }
        if (sum & 1)
            return false;
        int t = sum >> 1;
        if (maxNum > t)
            return false;
        vector<vector<bool>> dp(n, vector<bool>(t + 1, false));
        for (int i = 0; i < n; i++)
            dp[i][0] = true;
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++)
        {
            int num = nums[i];
            for (int j = 1; j <= t; j++)
            {
                if (j > num)
                {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][t];
    }
};