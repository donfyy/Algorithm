#include <stdbool.h>
bool search(int *nums, int n, int t)
{
    int l = 0, r = n - 1, m;
    while (l <= r)
    {
        m = l + ((r - l) >> 1);
        if (t == nums[m])
            return true;
        if (nums[m] > nums[l])
        {
            if (t >= nums[l] && t < nums[m])
            {
                r = m - 1;
            }
            else
            {
                l = m + 1;
            }
        }
        else if (nums[m] < nums[l])
        {
            if (t > nums[m] && t <= nums[r])
            {
                l = m + 1;
            }
            else
            {
                r = m - 1;
            }
        }
        else if (nums[m] != nums[r])
        {
            l = m + 1;
        }
        else
        {
            l++;
        }
    }
    return false;
}