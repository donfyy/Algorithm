#include <vector>
using namespace std;
class UsingQuickSort
{
public:
    vector<int> smallerNumbersThanCurrent(vector<int> &nums)
    {
        const int n = nums.size();
        vector<pair<int, int>> sorted;
        for (int i = 0; i < n; i++)
        {
            sorted.emplace_back(nums[i], i);
        }
        sort(sorted.begin(), sorted.end());
        vector<int> ret(n);
        int cnt = 0;
        for (int i = 0; i < n; i++)
        {
            if (i == 0 || sorted[i].first != sorted[i - 1].first)
            {
                cnt = i;
            }
            ret[sorted[i].second] = cnt;
        }
        return ret;
        ;
    }
};
class UsingCountingSort
{
public:
    // O(N + K) O(K)
    vector<int> smallerNumbersThanCurrent(vector<int> &nums)
    {
        // 比当前数字小的数字可以在当前数字的左侧也可以在当前数字的右侧
        // 如果不对原数组进行处理，为每个数字扫描一次数组，时间O(n^2)
        // 如果比当前数字小的数字都在当前数字的一侧就可以，就可以直接求出数字的数目
        // 排序的时间复杂度是O(nlogn) 小于 O(n^2)
        // 由于数字的取值范围有限，所以可以想到用计数排序
        const int n = nums.size(), m = 101;
        vector<int> bucket(m);
        for (int num : nums)
            bucket[num]++;
        for (int i = 1; i < m; i++)
            bucket[i] += bucket[i - 1];
        vector<int> ret(n);
        for (int i = 0; i < n; i++)
            ret[i] = nums[i] == 0 ? 0 : bucket[nums[i] - 1];
        return ret;
    }
};