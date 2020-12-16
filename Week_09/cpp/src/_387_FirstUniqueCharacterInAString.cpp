#include <string>
using namespace std;
class Solution
{
public:
    int firstUniqChar(string s)
    {
        int freq[26] = {0};
        for (char it : s)
        {
            freq[it - 'a']++;
        }
        for (int i = 0, n = s.size(); i < n; i++)
        {
            if (freq[s[i] - 'a'] == 1)
                return i;
        }
        return -1;
    }
};