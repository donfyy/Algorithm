#include <vector>
using namespace std;
// todo 数状数组
class UsingMergeSort
{
public:
    int reversePairs(vector<int> &nums)
    {
        vector<int> cache(nums.size());
        return merge(nums, 0, nums.size() - 1, cache);
    }

    int merge(vector<int> &nums, int left, int right, vector<int> &cache)
    {
        if (left >= right)
            return 0;
        int mid = left + ((right - left) >> 1);
        int ret = merge(nums, left, mid, cache);
        ret += merge(nums, mid + 1, right, cache);

        int i = mid, j = right, k = j;
        while (i >= left)
        {
            while (j > mid && nums[i] <= nums[j])
            {
                cache[k--] = nums[j--];
            }
            ret += j - mid;
            cache[k--] = nums[i--];
        }
        while (j > mid)
        {
            cache[k--] = nums[j--];
        }
        for (k = left; k <= right; k++)
        {
            nums[k] = cache[k];
        }
        return ret;
    }
};