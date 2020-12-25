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
    bool isIsomorphic(string s, string t)
    {
        if (s.size() != t.size())
            return false;
        int lastPosS[256] = {0}, lastPosT[256] = {0}, n = s.size();
        for (int i = 0; i < n; i++)
        {
            if (lastPosS[s[i]] != lastPosT[t[i]])
                return false;
            lastPosS[s[i]] = i + 1;
            lastPosT[t[i]] = i + 1;
        }
        return true;
    }
};