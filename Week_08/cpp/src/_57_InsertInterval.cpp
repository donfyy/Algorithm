#include <vector>
using namespace std;
class Solution
{
public:
    // O(n)
    // 我没有想到要将重叠区间合并，也少考虑了一种情况
    // 我一直纠结于修改原来的数组。
    vector<vector<int>> insert(vector<vector<int>> &intervals, vector<int> &newInterval)
    {
        // 往以左端点排序的无重叠区间列表中插入一个新区间
        // 假设新区间为[l, r]，则考虑列表中每一个区间[li, ri]
        // 如果[li, ri]如果[li, ri]有重叠则合并[li, ri]到[l, r]
        // 最后将合并后的[l, r]加入到结果数组中
        vector<vector<int>> ret;
        int l = newInterval[0], r = newInterval[1];
        bool placed = false;
        for (const auto &it : intervals)
        {
            if (it[1] < l)
            {
                ret.push_back(it);
            }
            else if (r < it[0])
            {
                if (!placed)
                {
                    ret.push_back({l, r});
                    placed = true;
                }
                ret.push_back(it);
            }
            else
            {
                l = min(l, it[0]);
                r = max(r, it[1]);
            }
        }
        if (!placed)
        {
            ret.push_back({l, r});
        }
        return ret;
    }
};