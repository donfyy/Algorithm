#include <vector>
using namespace std;
class Solution
{
public:
    vector<int> countSmaller(vector<int> &nums)
    {
        const int n = nums.size();
        vector<int> indices(n), counts(n), cache(n);
        for (int i = 0; i < n; i++)
        {
            indices[i] = i;
        }
        merge(nums, indices, counts, cache, 0, n - 1);
        return counts;
    }

    void merge(vector<int> &nums, vector<int> &indices, vector<int> &counts, vector<int> &cache, int left, int right)
    {
        if (left >= right)
            return;
        int mid = left + ((right - left) >> 1);
        merge(nums, indices, counts, cache, left, mid);
        merge(nums, indices, counts, cache, mid + 1, right);

        int i = mid, j = right, k = right;
        while (i >= left)
        {
            while (j > mid && nums[indices[i]] <= nums[indices[j]])
            {
                cache[k--] = indices[j--];
            }
            counts[indices[i]] += j - mid;
            cache[k--] = indices[i--];
        }
        while (j > mid)
            cache[k--] = indices[j--];
        copy(cache.begin() + left, cache.begin() + right + 1, indices.begin() + left);
    }
};