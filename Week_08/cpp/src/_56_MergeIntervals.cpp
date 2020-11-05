#include <vector>
using namespace std;
class Solution
{
public:
    // O(nlogn) O(1)
    vector<vector<int>> merge(vector<vector<int>> &intervals)
    {
        // 考虑某一个区间[l, r]与之重叠的所有区间分散在数组中的各个位置
        // 所以需要扫描数组中的每一个元素以找到与[l, r]重叠的所有区间
        // 因此暴力法是O(n^2)
        // 能否通过某种方式将不连续的重叠区间放在连续的位置上？
        // 通过将数组以区间的左端点排序可以做到
        // 这样先排序，然后顺序扫描排序后的数组顺序将每一个重叠的区间集合合并成一个区间，
        // 然后将该区间放到结果数组中
        if (intervals.empty())
            return {};
        sort(intervals.begin(), intervals.end());
        vector<vector<int>> ret;
        auto *p = &intervals[0];
        for (auto &it : intervals)
        {
            if ((*p)[1] < it[0])
            {
                ret.push_back(*p);
                p = &it;
            }
            else
            {
                (*p)[1] = max((*p)[1], it[1]);
            }
        }
        ret.push_back(*p);
        return ret;
    }
};