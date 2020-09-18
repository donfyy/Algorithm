#include <vector>
using namespace std;
class Solution
{
public:
    bool search(vector<int> &nums, int t)
    {
        int l = 0, r = nums.size() - 1, m;
        while (l <= r)
        {
            m = l + ((r - l) >> 1);
            if (t == nums[m])
                return true;
            if (nums[m] > nums[r])
            {
                if (t > nums[m] || t <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            }
            else if (nums[m] < nums[r])
            {
                if (t > nums[m] && t <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            }
            else if (nums[m] > nums[l])
            {
                if (t > nums[m])
                    return false;
                r = m - 1;
            }
            else if (nums[m] < nums[l])
            {
                r = m - 1;
            }
            else
            {
                l++;
            }
        }
        return false;
    }
};