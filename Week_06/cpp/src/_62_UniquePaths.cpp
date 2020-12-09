#include <vector>
using namespace std;
class UsingDp
{
public:
    int uniquePaths(int m, int n)
    {
        // [i, j]只能从[i - 1, j]或者[i, j - 1]到达
        // f(i, j)表示到达[i, j]的路径个数
        // f(i, j) = f(i - 1, j) + f(i, j - 1)
        // f(0, 0) = 1
        // f(0, j) = 1
        // f(i, 0) = 1
        vector<int> dp(n, 1);
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
};

class UsingMath
{
public:
    int uniquePaths(int m, int n)
    {
        // 从m + n - 2次移动中选择m - 1次向下移动
        // c(m + n - 2, m - 1) = (m + n - 2)*...*n/(m - 1)! = (m + n - 2)! / ((m - 1)!*(n - 1)!)
        long ret = 1;
        for (int i = n, j = 1; j < m; i++, j++)
        {
            ret = ret * i / j;
        }
        return ret;
    }
};