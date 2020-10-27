#include <vector>
using namespace std;
class UsingCountingSort
{
public:
    vector<int> smallerNumbersThanCurrent(vector<int> &nums)
    {
        const int n = nums.size();
        vector<pair<int, int>> sorted;
        for (int i = 0; i < n; i++)
        {
            sorted.emplace_back(nums[i], i);
        }
        sort(sorted.begin(), sorted.end());
        vector<int> ret(n);
        int cnt = 0;
        for (int i = 0; i < n; i++)
        {
            if (i == 0 || sorted[i].first != sorted[i - 1].first)
            {
                cnt = i;
            }
            ret[sorted[i].second] = cnt;
        }
        return ret;
        ;
    }
};