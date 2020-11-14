#include <vector>
#include <unordered_map>
#include <string>

using namespace std;
class Solution
{
public:
    // O(M * NlogN) M 为字符串的个数 N为字符串的平均长度
    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        // 字母相同，但排列不同
        // 考虑组合在一起的字母异位词，字母相同，排列不同，因此可以将其中的某个排列作为这组异位词的key
        unordered_map<string, vector<string>> m;
        const auto key = [&](string s) -> string & {
            // 可以改变key生成的算法
            // 可以使用计数排序生成key O(n)
            // 这里采用排序O(nlogn)
            // 还可以利用质数生成key O(n) 空间消耗少
            sort(s.begin(), s.end());
            return s;
        };
        for (const auto &it : strs)
        {
            m[key(it)].push_back(it);
        }

        vector<vector<string>> ret;
        for (const auto &[_, it] : m)
        {
            ret.push_back(it);
        }
        return ret;
    }
};
class UsingPrime
{
public:
    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        unordered_map<double, vector<string>> map;
        double a[26] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        for (auto &s : strs)
        {
            auto key = 1.0;
            for (auto c : s)
            {
                key *= a[c - 'a'];
            }
            map[key].push_back(s);
        }
        vector<vector<string>> ret;
        for (auto &pair : map)
        {
            ret.push_back(pair.second);
        }
        return ret;
    }
};