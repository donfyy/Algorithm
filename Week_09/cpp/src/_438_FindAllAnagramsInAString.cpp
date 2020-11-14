#include <vector>
#include <unordered_map>
#include <string>
using namespace std;
class UsingVariableSlideWindow
{
public:
    vector<int> findAnagrams(string s, string p)
    {
        // 考虑到要匹配的子串是字母异位词，而不是相等匹配，因此可用滑动窗口
        // 从具体到抽象
        const int m = s.size(), n = p.size();
        if (m < n)
            return {};
        unordered_map<char, int> freq;
        for (char it : p)
        {
            freq[it]++;
        }
        int cnt = freq.size(), l = 0, r = 0;
        vector<int> ret;
        while (r < m)
        {
            if (freq.count(s[r]))
            {
                freq[s[r]]--;
                if (!freq[s[r]])
                    cnt--;
            }
            r++;
            while (!cnt)
            {
                if (r - l == n)
                    ret.push_back(l);
                if (freq.count(s[l]))
                {
                    if (!freq[s[l]])
                        cnt++;
                    freq[s[l]]++;
                }
                l++;
            }
        }
        return ret;
    }
};