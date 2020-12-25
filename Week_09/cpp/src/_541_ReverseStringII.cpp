#include <string>
using namespace std;
class Solution
{
public:
    string reverseStr(string s, int k)
    {
        int n = s.size();
        auto reverse = [&](int l, int r) {
            while (l < r)
            {
                swap(s[l++], s[r--]);
            }
        };
        for (int i = 0; i < n; i += k << 1)
        {
            reverse(i, min(n, i + k) - 1);
        }
        return s;
    }
};