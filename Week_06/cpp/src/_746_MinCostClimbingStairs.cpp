#include <vector>
using namespace std;
class Dp1
{
public:
    int minCostClimbingStairs(vector<int> &cost)
    {
        // f(i) 表示从i起跳的最低花费
        int p = 0, q = 0;
        for (auto it : cost)
        {
            auto t = min(p, q) + it;
            p = q;
            q = t;
        }
        return min(p, q);
    }
};
class Dp2
{
public:
    int minCostClimbingStairs(vector<int> &cost)
    {
        // f(i) 表示到达i的最低花费
        int n = cost.size();
        if (n < 2)
            return 0;
        int p = 0, q = 0;
        for (int i = 2; i <= n; i++)
        {
            int t = min(p + cost[i - 2], q + cost[i - 1]);
            p = q;
            q = t;
        }
        return q;
    }
};