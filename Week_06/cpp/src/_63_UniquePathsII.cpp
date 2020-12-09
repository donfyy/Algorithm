#include <vector>
using namespace std;
class Solution
{
public:
    int uniquePathsWithObstacles(vector<vector<int>> &obstacleGrid)
    {
        // f(i, j) = f(i - 1, j) + f(i, j - 1)
        const int m = obstacleGrid.size(), n = obstacleGrid[0].size();
        vector<int> dp(n);
        for (int j = 0; j < n; j++)
        {
            if (obstacleGrid[0][j])
                break;
            dp[j] = 1;
        }
        for (int i = 1; i < m; i++)
        {
            if (obstacleGrid[i][0])
                dp[0] = 0;
            for (int j = 1; j < n; j++)
            {
                dp[j] = obstacleGrid[i][j] ? 0 : dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
};