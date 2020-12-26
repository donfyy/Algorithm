#include <string>
#include <unordered_map>
#include <unordered_set>
using namespace std;
class Solution
{
public:
    bool isIsomorphic(string s, string t)
    {
        if (s.size() != t.size())
            return false;
        unordered_map<char, char> m;
        unordered_set<char> v;
        const int n = s.size();
        for (int i = 0; i < n; i++)
        {
            if (m.count(s[i]))
            {
                if (m[s[i]] != t[i])
                    return false;
            }
            else
            {
                if (v.count(t[i]))
                    return false;
                m[s[i]] = t[i];
                v.emplace(t[i]);
            }
        }
        return true;
    }
};
class Solution2
{
public:
    // 将字符映射到数字
    bool isIsomorphic(string s, string t)
    {
        if (s.size() != t.size())
            return false;
        int ms[256] = {0}, mt[256] = {0};
        for (int i = 0; i < s.size(); i++)
        {
            if (ms[s[i]] != mt[t[i]])
                return false;
            ms[s[i]] = mt[t[i]] = i + 1;
        }
        return true;
    }
};