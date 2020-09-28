#include <unordered_set>
#include <vector>
using namespace std;
struct pair_hash
{
    template <class T1, class T2>
    std::size_t operator()(const std::pair<T1, T2> &p) const
    {
        auto h1 = std::hash<T1>{}(p.first);
        auto h2 = std::hash<T2>{}(p.second);
        return h1 ^ h2;
    }
};

class Solution
{
public:
    // 注意使用unordered_set与pair需要自定义哈希函数
    // 方向的切换颇为巧妙
    int robotSim(vector<int> &commands, vector<vector<int>> &obstacles)
    {
        vector<pair<int, int>> dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        unordered_set<pair<int, int>, pair_hash> obSet;
        for (auto &point : obstacles)
        {
            obSet.emplace(point[0], point[1]);
        }
        int ret = 0, di = 0, x = 0, y = 0;
        for (int cmd : commands)
        {
            if (cmd == -2)
            {
                di = (di + 1) % 4;
            }
            else if (cmd == -1)
            {
                di = (di + 3) % 4;
            }
            else
            {
                for (int i = 0; i < cmd; i++)
                {
                    auto &[dx, dy] = dirs[di];
                    int p = x + dx;
                    int q = y + dy;
                    if (obSet.find(make_pair(p, q)) != obSet.end())
                        break;
                    x = p;
                    y = q;
                    ret = max(ret, p * p + q * q);
                }
            }
        }
        return ret;
    }
};