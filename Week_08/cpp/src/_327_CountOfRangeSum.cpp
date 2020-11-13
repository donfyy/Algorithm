#include <vector>
using namespace std;
class Solution
{
public:
    // O(nlogn) O(n)
    // todo 数状数组，平衡二叉树等解法
    int countRangeSum(vector<int> &nums, int lower, int upper)
    {
        // 暴力法：使用两个指针i和j，枚举所有的区间[i, j]然后线性扫描该区间求和，时间复杂度O(n^3)
        // 注意到区间[i, j]的和实际上是前j + 1个元素的和减去前i个元素的和，因此我们可以使用前缀和
        // pre[i]表示前i个元素的和，题目就变成给定pre[j]找到pre[i] 使得 lower <= pre[j] - pre[i] <= upper
        // 只想到了前缀和的暴力
        long s = 0;
        vector<long> preSum{0};
        for (int it : nums)
        {
            s += it;
            preSum.push_back(s);
        }
        vector<long> cache(preSum.size());
        return merge(preSum, cache, 0, preSum.size() - 1, lower, upper);
    }

    int merge(vector<long> &nums, vector<long> &cache, int left, int right, int lower, int upper)
    {
        if (left >= right)
        {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        int ret = 0;
        ret += merge(nums, cache, left, mid, lower, upper);
        ret += merge(nums, cache, mid + 1, right, lower, upper);

        // 没有想到用归并排序，只能说前面翻转对理解的不透彻
        int i = left, l = mid + 1, r = mid + 1;
        while (i <= mid)
        {
            while (l <= right && nums[l] - nums[i] < lower)
                l++;
            while (r <= right && nums[r] - nums[i] <= upper)
                r++;
            ret += r - l;
            i++;
        }

        i = left;
        l = left;
        r = mid + 1;
        while (l <= mid)
        {
            while (r <= right && nums[r] < nums[l])
                cache[i++] = nums[r++];
            cache[i++] = nums[l++];
        }
        while (r <= right)
            cache[i++] = nums[r++];
        for (i = left; i <= right; i++)
        {
            nums[i] = cache[i];
        }
        return ret;
    }
};
class UsingMergeSort2
{
public:
    int countRangeSum(vector<int> &nums, int lower, int upper)
    {
        // 区间和->前缀和之差
        vector<long> pre{0};
        for (int it : nums)
            pre.push_back(pre.back() + it);
        const int n = pre.size();
        vector<long> cache(n);
        return merge(pre, 0, n - 1, lower, upper, cache);
    }

    int merge(vector<long> &pre, int left, int right, int lower, int upper, vector<long> &cache)
    {
        if (left >= right)
            return 0;
        int mid = left + ((right - left) >> 1);
        int ret = merge(pre, left, mid, lower, upper, cache);
        ret += merge(pre, mid + 1, right, lower, upper, cache);

        // 注意训练逻辑推理能力
        // pre[j] - pre[i] in [lower, upper]
        // j - i >= lower  j - i <= upper
        // j - upper <= i <= j - lower
        // lower + i <= j <= i + upper
        int l = left, r = l;
        for (int j = mid + 1; j <= right; j++)
        {
            while (l <= mid && pre[j] - upper > pre[l])
                l++;
            while (r <= mid && pre[j] - lower >= pre[r])
                r++;
            ret += r - l;
        }
        // int l = mid + 1, r = l;
        // for (int i = left; i <= mid; i++) {
        //     while (l <= right && pre[l] < lower + pre[i]) l++;
        //     while (r <= right && pre[r] <= upper + pre[i]) r++;
        //     ret += r - l;
        // }

        // merge
        int i = left, j = mid + 1, k = left;
        while (i <= mid)
        {
            while (j <= right && pre[j] < pre[i])
                cache[k++] = pre[j++];
            cache[k++] = pre[i++];
        }
        while (j <= right)
            cache[k++] = pre[j++];
        copy(cache.begin() + left, cache.begin() + right + 1, pre.begin() + left);
        return ret;
    }
};