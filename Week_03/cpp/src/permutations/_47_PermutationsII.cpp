#include <vector>
#include <iostream>

using namespace std;

class Solution
{
public:
    vector<vector<int>> ret;
    vector<vector<int>> permuteUnique(vector<int> &nums)
    {
        dfs(nums, 0);
        return ret;
    }
    void dfs(vector<int> &nums, int start)
    {
        if (start == nums.size() - 1)
        {
            ret.push_back(nums);
            return;
        }
        for (int i = start; i < nums.size(); i++)
        {
            bool duplicate = false;
            for (int j = start; j < i; j++)
            {
                if (nums[j] == nums[i])
                {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate)
                continue;
            swap(nums[i], nums[start]);
            dfs(nums, start + 1);
            swap(nums[i], nums[start]);
        }
    }
};