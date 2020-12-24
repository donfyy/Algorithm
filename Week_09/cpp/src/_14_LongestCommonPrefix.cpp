#include <vector>
#include <string>
using namespace std;
class Solution
{
public:
    string longestCommonPrefix(vector<string> &strs)
    {
        // 按列比较
        if (strs.empty())
            return "";
        auto &first = strs[0];
        auto n = first.size(), m = strs.size();
        for (int i = 0; i < n; i++)
        {
            for (int j = 1; j < m; j++)
            {
                auto &curr = strs[j];
                if (i == curr.size() || first[i] != curr[i])
                {
                    return first.substr(0, i);
                }
            }
        }
        return first;
    }
};