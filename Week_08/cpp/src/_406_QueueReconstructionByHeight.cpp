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
class UsingSortAscending
{
public:
    // 注意逆向思维的应用，若将所有的元素按照身高从小到大排序，则对于第i个元素来说
    // 假设[0, i - 1]元素已经有序，并且因为[0, i - 1]个元素的身高都比第i个元素要低
    // 因此我们预留ki个空位置用来存放身高大于等于hi的元素
    // 这就是逆向思维，我昨天没想到，要想到这一点才行。
    vector<vector<int>> reconstructQueue(vector<vector<int>> &people)
    {
        sort(people.begin(), people.end(), [](vector<int> &l, vector<int> &r) {
            return l[0] == r[0] ? l[1] > r[1] : l[0] < r[0];
        });

        const int n = people.size();
        vector<vector<int>> ret(n);
        for (const auto &it : people)
        {
            int spaces = it[1] + 1;
            for (int i = 0; i < n; i++)
            {
                if (ret[i].empty())
                {
                    spaces--;
                    if (!spaces)
                    {
                        ret[i] = it;
                    }
                }
            }
        }
        return ret;
    }
};