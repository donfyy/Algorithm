#include <string>

using namespace std;
class Solution
{
public:
    bool isAnagram(string s, string t)
    {
        if (s.size() != t.size())
            return false;
        int map[26] = {0};
        for (auto i = 0; i < s.size(); i++)
        {
            map[s[i] - 'a']++;
            map[t[i] - 'a']--;
        }
        for (auto c : map)
        {
            if (c != 0)
                return false;
        }
        return true;
    }
};