#include <vector>
using namespace std;
class RadixSort
{
public:
    int maximumGap(vector<int> &nums)
    {
        const int n = nums.size();
        if (n < 2)
            return 0;
        const int maxVal = *max_element(nums.begin(), nums.end());
        vector<int> buf(n);
        for (int div = 1; div <= maxVal; div *= 10)
        {
            vector<int> cnt(10);
            for (int it : nums)
            {
                cnt[(it / div) % 10]++;
            }
            for (int i = 1; i < 10; i++)
            {
                cnt[i] += cnt[i - 1];
            }
            for (int i = n - 1; i >= 0; i--)
            {
                buf[cnt[(nums[i] / div) % 10]-- - 1] = nums[i];
            }
            copy(buf.begin(), buf.end(), nums.begin());
        }

        int ret = 0;
        for (int i = 1; i < n; i++)
        {
            ret = max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }
};
class BucketSort 
{
public:
    int maximumGap(vector<int> &nums)
    {
        // 先证明最大间距不小于(max - min) / (n - 1)
        // 假设最大间距都小于(max - min) / (n - 1) 排序后的元素顺序为A1...An
        // 则An - A1 = (An - An-1) + (An-1 - An-2) + ... + (A2 - A1)
        // < (n - 1) * (max - min) / (n - 1) = max - min，矛盾
        // 因此结论成立
        // 将bucketSize = floor((max - min) / (n - 1));
        // 则桶内元素的最大值与最小值之差 最大为bucketSize - 1，
        // 因此具有最大间距的两个元素一定位于不同的桶内
        // 因此只需要记录桶内的最大值和最小值即可，然后逐个比较桶与桶之间的最大与最小值之差即可得出结论
        // 这道题一开始不能理解桶排序的原因在于没有想清楚桶内元素的最大值与最小值之差
        const int n = nums.size();
        if (n < 2)
            return 0;
        const auto [pmin, pmax] = minmax_element(nums.begin(), nums.end());
        const int minVal = *pmin, maxVal = *pmax;
        const int bucketSize = max(1, (maxVal - minVal) / (n - 1));
        const int bucketCount = (maxVal - minVal) / bucketSize + 1;
        vector<pair<int, int>> bucket(bucketCount, {-1, -1});
        for (int it : nums)
        {
            auto &p = bucket[(it - minVal) / bucketSize];
            if (p.first == -1)
            {
                p.first = p.second = it;
            }
            else
            {
                p.first = min(p.first, it);
                p.second = max(p.second, it);
            }
        }
        int ret = 0, prev = -1;
        for (int i = 0; i < bucketCount; i++)
        {
            auto &p = bucket[i];
            if (p.first == -1)
                continue;
            if (prev != -1)
            {
                ret = max(ret, p.first - bucket[prev].second);
            }
            prev = i;
        }
        return ret;
    }
};