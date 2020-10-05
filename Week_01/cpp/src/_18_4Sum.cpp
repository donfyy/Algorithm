#include <vector>
using namespace std;
class Solution
{
public:
    vector<vector<int>> fourSum(vector<int> &nums, int target)
    {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<vector<int>> ret;
        for (int i = 0; i < n - 3; i++)
        {
            if (nums[i] > 0 && nums[i] > target)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int t1 = target - nums[i];
            for (int j = i + 1; j < n - 2; j++)
            {
                if (nums[j] > 0 && nums[j] > t1)
                    break;
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int l = j + 1, r = n - 1, t2 = t1 - nums[j];
                while (l < r)
                {
                    int t = t2 - nums[l] - nums[r];
                    if (t == 0)
                    {
                        ret.push_back({nums[i], nums[j], nums[l], nums[r]});
                        while (l < r && nums[l] == nums[++l])
                            ;
                        while (l < r && nums[r] == nums[--r])
                            ;
                    }
                    else if (t < 0)
                    {
                        while (l < r && nums[r] == nums[--r])
                            ;
                    }
                    else
                    {
                        while (l < r && nums[l] == nums[++l])
                            ;
                    }
                }
            }
        }
        return ret;
    }
};