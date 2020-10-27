#include <vector>
using namespace std;
class UsingCountingSort
{
public:
    vector<int> smallerNumbersThanCurrent(vector<int> &nums)
    {
        // 返回一个数组，在i这个位置保存nums中比nums[i]小的元素的数目
        const int n = nums.size();
        vector<int> cnt(101), ret;
        for (int i = 0; i < n; i++)
        {
            cnt[nums[i]]++;
        }
        for (int i = 1; i < 101; i++)
        {
            cnt[i] += cnt[i - 1];
        }
        for (int i = 0; i < n; i++)
        {
            ret.push_back(nums[i] == 0 ? 0 : cnt[nums[i] - 1]);
        }
        return ret;
    }
};
class UsingQuickSort
{
public:
    vector<int> smallerNumbersThanCurrent(vector<int> &nums)
    {
        // 返回一个数组，在i这个位置保存nums中比nums[i]小的元素的数目
        const int n = nums.size();
        // 保存原数组中每个元素对应的下标位置
        vector<pair<int, int>> t;
        for (int i = 0; i < n; i++)
        {
            t.emplace_back(nums[i], i);
        }
        // 对新数组进行排序
        sort(t.begin(), t.end());
        vector<int> ret(n);
        // prev用来记录比新数组当前元素小的元素所在的下标位置
        // 该位置就是比当前元素小的元素的数目
        int prev = -1;
        for (int i = 0; i < n; i++)
        {
            if (i == 0 || t[i].first != t[i - 1].first)
            {
                prev = i;
            }
            ret[t[i].second] = prev;
        }
        return ret;
    }
};