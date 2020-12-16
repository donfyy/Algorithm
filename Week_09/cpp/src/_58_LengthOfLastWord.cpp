#include <string>
using namespace std;
class Solution
{
public:
    int lengthOfLastWord(string s)
    {
        // 该想法来自于区间和
        const int n = s.size();
        int r = n - 1;
        while (r >= 0 && s[r] == ' ')
            r--;
        int l = r;
        while (l >= 0 && s[l] != ' ')
            l--;
        return r - l;
    }
};