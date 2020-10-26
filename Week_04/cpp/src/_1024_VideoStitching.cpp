#include <vector>
using namespace std;
// 看不懂啊，题目的意思读不明白啊
class UsingDp
{
public:
    int videoStitching(vector<vector<int>> &clips, int T)
    {
        vector<int> dp(T + 1, INT_MAX - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++)
        {
            for (const auto &it : clips)
            {
                if (it[0] < i && i <= it[1])
                {
                    dp[i] = min(dp[i], dp[it[0]] + 1);
                }
            }
        }
        return dp[T] == INT_MAX - 1 ? -1 : dp[T];
    }
};
class UsingGreedy
{
public:
    int videoStitching(vector<vector<int>> &clips, int T)
    {
        // maxr[i] 表示以i为左端点的所有子区间中最远的右端点
        // r 所有左端点不大于i的子区间中可以覆盖的最远的右端点
        // pre 表示上一个被使用的子区间的结束位置
        vector<int> maxr(T);
        for (const auto &it : clips)
        {
            if (it[0] < T)
                maxr[it[0]] = max(maxr[it[0]], it[1]);
        }
        int r = 0, pre = 0, ret = 0;
        for (int i = 0; i < T; i++)
        {
            r = max(r, maxr[i]);
            if (r == i)
                return -1;
            if (i == pre)
            {
                ret++;
                pre = r;
            }
        }
        return ret;
    }
};