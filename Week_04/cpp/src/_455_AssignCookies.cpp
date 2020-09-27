#include <vector>
using namespace std;
class Solution
{
public:
    int findContentChildren(vector<int> &g, vector<int> &s)
    {
        int i = 0, j = 0, m = g.size(), n = s.size();
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        while (i < m && j < n)
        {
            if (s[j] >= g[i])
            {
                i++;
                j++;
            }
            else
            {
                j++;
            }
        }
        return i;
    }
};