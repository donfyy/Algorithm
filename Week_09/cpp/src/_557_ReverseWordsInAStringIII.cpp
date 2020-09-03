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