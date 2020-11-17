#include <vector>
using namespace std;
class UsingSort
{
public:
    // O(n^2)
    vector<vector<int>> reconstructQueue(vector<vector<int>> &people)
    {
        // 考虑元素a(h, k) 及元素b(h, k)
        // 查看两个元素a和b能否比较
        // 如果 a.h > b.h
        // 先按照h递减的顺序排序
        // [7, 0] [7, 1] [6, 1] [5, 0] [5, 2] [4, 4]
        // 0,     1,     2,     3,     4,     5
        // [4, 4] [5, 0] [5, 2] [6, 1] [7, 0] [7, 1]
        sort(people.begin(), people.end(), [](vector<int> &u, vector<int> &v) {
            return u[0] > v[0] || (u[0] == v[0] && u[1] <= v[1]);
        });
        const int n = people.size();
        vector<int> idx;
        vector<vector<int>> ret;
        for (int i = 0; i < n; i++)
        {
            idx.insert(idx.begin() + people[i][1], i);
        }
        for (const int i : idx)
        {
            ret.push_back(people[i]);
        }
        return ret;
    }
};