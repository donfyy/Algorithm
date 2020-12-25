#include <string>
using namespace std;
class Solution
{
public:
    string reverseWords(string s)
    {
        int j = -1, n = s.size();
        for (int i = 0; i < n; i++)
        {
            if (s[i] == ' ' && (j == -1 || s[j] == ' '))
                continue;
            s[++j] = s[i];
        }
        if (j < n && s[j] == ' ')
            j--;

        auto reverse = [&](int l, int r) {
            while (l < r)
            {
                swap(s[l++], s[r--]);
            }
        };
        reverse(0, j);
        int i = 0;
        while (i <= j)
        {
            int k = i;
            while (k <= j && s[k] != ' ')
                k++;
            reverse(i, k - 1);
            i = k + 1;
        }
        return s.substr(0, j + 1);
    }
};