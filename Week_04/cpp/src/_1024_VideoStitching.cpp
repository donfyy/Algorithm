#include <vector>
using namespace std;
// 看不懂啊，题目的意思读不明白啊
// 第一次看不懂，也要硬着头皮看，这就是在学习新知识。
// 不同的人基础不同，同样的题要多过遍数。
// 一开始看不懂官方题解，因为写官方题解的人基础好，很多隐含信息没有基础的人是读不懂的，所以就是要多过遍数
// 2020.11.09
// 2020.11.07
// 2020.11.06
// 2020.11.05
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
        // 对于所有左端点相同的子区间，其右端点越远越有利。
        // 对于当前的位置i，每次选择能够覆盖i的所有子区间中右端点最远的那个子区间。
        // 所以要求出覆盖i的所有子区间的最远右端点。
        // 这样就可以从0开始，每次选择覆盖当前位置的最远子区间，就可以用最少的区间覆盖整个位置
        // maxr[i] 记录覆盖i的所有子区间的最远右端点
        // r 当前选择的子区间的最远右端点
        // nextR 下一次选择的子区间的最远右端点
        vector<int> maxr(T);
        for (const auto &clip : clips)
        {
            if (clip[0] < T)
            {
                maxr[clip[0]] = max(maxr[clip[0]], clip[1]);
            }
        }
        int r = 0, nextR = 0, ret = 0;
        for (int i = 0; i < T; i++)
        {
            nextR = max(nextR, maxr[i]);
            if (i == nextR)
            {
                return -1;
            }
            if (i == r)
            {
                ret++;
                r = nextR;
            }
        }
        return ret;
    }
};