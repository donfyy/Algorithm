#include <vector>
using namespace std;
class Solution
{
public:
    void moveZeroes(vector<int> &nums)
    {
        int j = -1, n = nums.size();
        for (int i = 0; i < n; i++)
        {
            if (nums[i])
            {
                swap(nums[++j], nums[i]);
            }
        }
    }
};