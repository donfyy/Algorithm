#include <vector>
#include <string>
using namespace std;
class Solution
{
public:
    // 求出所有字符，每个字符在所有字符串中出现次数的最小值
    vector<string> commonChars(vector<string> &A)
    {
        vector<int> minfreq(26, INT_MAX), freq(26, 0);
        for (auto &s : A)
        {
            fill(freq.begin(), freq.end(), 0);
            for (auto c : s)
            {
                ++freq[c - 'a'];
            }
            for (int i = 0; i < 26; i++)
            {
                minfreq[i] = min(minfreq[i], freq[i]);
            }
        }
        vector<string> ret;
        for (int i = 0; i < 26; i++)
        {
            for (int j = 0; j < minfreq[i]; j++)
            {
                ret.emplace_back(1, i + 'a');
            }
        }
        return ret;
    }
};