#include <string>
using namespace std;
class _557_
{
public:
    string reverseWords(string s)
    {
        int i = 0, j = 0, n = s.length();
        while (i < n)
        {
            while (s[j] && s[j] != ' ')
                j++;
            int next = j-- + 1;
            while (i < j)
                swap(s[i++], s[j--]);
            i = next;
            j = next;
        }
        return s;
    }
};
class Solution1
{
public:
    string reverseWords(string s)
    {
        int i = 0, n = s.size();
        auto reverse = [&](int l, int r) {
            while (l < r)
            {
                swap(s[l++], s[r--]);
            }
        };
        while (i < n)
        {
            int j = i;
            while (s[j] && s[j] != ' ')
                j++;
            reverse(i, j - 1);
            i = j + 1;
        }
        return s;
    }
};