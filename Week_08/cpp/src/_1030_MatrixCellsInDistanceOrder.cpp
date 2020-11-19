#include <vector>
using namespace std;
class UsingMath
{
public:
    // 几何法，尚未搞懂点数是怎么计算的
    // O((R + C) ^ 2) O(1)
    vector<vector<int>> allCellsDistOrder(int R, int C, int r0, int c0)
    {
        vector<vector<int>> dirs{{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
        vector<vector<int>> ret{{r0, c0}};
        int r = r0, c = c0;
        int maxDist = max(r0, R - r0 - 1) + max(c0, C - c0 - 1);
        for (int dist = 1; dist <= maxDist; dist++)
        {
            r--;
            for (int i = 0; i < 4; i++)
            {
                while ((!(i & 1) && r != r0) || ((i & 1) && c != c0))
                {
                    if (r >= 0 && r < R && c >= 0 && c < C)
                    {
                        ret.push_back({r, c});
                    }
                    r += dirs[i][0];
                    c += dirs[i][1];
                }
            }
        }
        return ret;
    }
};
class UsingBucketSort
{
public:
    vector<vector<int>> allCellsDistOrder(int R, int C, int r0, int c0)
    {
        int maxDist = max(r0, R - r0 - 1) + max(c0, C - c0 - 1);
        vector<vector<vector<int>>> buckets(maxDist + 1);

        const auto dist = [&](int r, int c) -> int { return abs(r - r0) + abs(c - c0); };
        for (int i = 0; i < R; i++)
        {
            for (int j = 0; j < C; j++)
            {
                // vector<int> t = {i, j};
                // buckets[dist(i, j)].push_back(move(t));
                buckets[dist(i, j)].push_back({i, j});
            }
        }
        vector<vector<int>> ret;
        for (const auto &bucket : buckets)
        {
            for (const auto &it : bucket)
            {
                ret.push_back(it);
            }
        }
        return ret;
    }
};