#include <vector>
using namespace std;
class Dp
{
public:
    vector<vector<int>> generate(int n)
    {
        if (n < 1)
            return {};
        vector<vector<int>> ret{{1}};
        for (int i = 1; i < n; i++)
        {
            vector<int> row{1};
            for (int j = 1; j < i; j++)
            {
                row.push_back(ret.back()[j] + ret.back()[j - 1]);
            }
            row.push_back(1);
            ret.push_back(row);
        }
        return ret;
    }
};