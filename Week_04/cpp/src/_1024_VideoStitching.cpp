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
        vector<int> maxn(T);
        for (const auto &it : clips)
        {
            if (it[0] < T)
                maxn[it[0]] = max(maxn[it[0]], it[1]);
        }
        int last = 0, pre = 0, ret = 0;
        for (int i = 0; i < T; i++)
        {
            last = max(last, maxn[i]);
            if (i == last)
                return -1;
            if (i == pre)
            {
                ret++;
                pre = last;
            }
        }
        return ret;
    }
};