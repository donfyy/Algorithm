#include <string>
using namespace std;
class MySolution
{
public:
    char findTheDifference(string s, string t)
    {
        int freq[26] = {0};
        for (char it : s)
        {
            freq[it - 'a']++;
        }
        for (char it : t)
        {
            freq[it - 'a']--;
        }
        for (int i = 0; i < 26; i++)
        {
            if (freq[i])
                return i + 'a';
        }
        return 0;
    }
};
class UsingMap
{
public:
    char findTheDifference(string s, string t)
    {
        int freq[26] = {0};
        for (auto &it : s)
        {
            freq[it - 'a']++;
        }
        for (auto &it : t)
        {
            if (--freq[it - 'a'] < 0)
                return it;
        }
        return ' ';
    }
};
class UsingSum
{
public:
    char findTheDifference(string s, string t)
    {
        int ret = 0;
        for (auto &it : t)
        {
            ret += it;
        }
        for (auto &it : s)
        {
            ret -= it;
        }
        return ret;
    }
};
class UsingBitwise
{
public:
    char findTheDifference(string s, string t)
    {
        int ret = 0;
        for (auto &it : s)
        {
            ret ^= it;
        }
        for (auto &it : t)
        {
            ret ^= it;
        }
        return ret;
    }
};