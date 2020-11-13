#include <vector>
using namespace std;
class UsingMergeSort
{
public:
    int reversePairs(vector<int> &nums)
    {
        // 翻转对->逆序对
        const int n = nums.size();
        vector<int> cache(n);
        return merge(nums, 0, n - 1, cache);
    }

    int merge(vector<int> &nums, int left, int right, vector<int> &cache)
    {
        if (left >= right)
            return 0;
        int mid = left + ((right - left) >> 1);
        int ret = merge(nums, left, mid, cache);
        ret += merge(nums, mid + 1, right, cache);

        // 固定i 求j 从右向左
        int i = mid, j = right, k = j, r = j;
        while (i >= left)
        {
            while (r > mid && nums[i] <= 2LL * nums[r])
                r--;
            ret += r - mid;
            while (j > mid && nums[j] > nums[i])
                cache[k--] = nums[j--];
            cache[k--] = nums[i--];
        }
        while (j > mid)
            cache[k--] = nums[j--];
        copy(cache.begin() + left, cache.begin() + right + 1, nums.begin() + left);
        return ret;
    }
};