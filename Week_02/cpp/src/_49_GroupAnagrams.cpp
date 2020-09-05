#include <vector>
#include <unordered_map>
#include <string>

using namespace std;

class Solution
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