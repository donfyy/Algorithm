#include <vector>
#include <unordered_map>
#include <unordered_set>
using namespace std;
class Solution
{
public:
    bool uniqueOccurrences(vector<int> &arr)
    {
        unordered_map<int, int> freq;
        for (int num : arr)
        {
            freq[num]++;
        }
        unordered_set<int> times;
        for (const auto &pair : freq)
        {
            if (times.count(pair.second))
                return false;
            times.insert(pair.second);
        }
        return true;
    }
};