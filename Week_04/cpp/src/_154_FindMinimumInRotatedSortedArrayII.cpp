#include <vector>
using namespace std;
class Solution
{
public:
    int findMin(vector<int> &nums)
    {
        int l = 0, r = nums.size() - 1;
        while (l < r)
        {
            if (nums[r] > nums[l])
                break;
            int m = l + ((r - l) >> 1);
            if (nums[m] > nums[l])
                l = m + 1;
            else if (nums[m] < nums[l])
                r = m;
            else
                l++;
        }
        return nums[l];
    }
};