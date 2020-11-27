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
        const auto [pmin, pmax] = minmax_element(nums.begin(), nums.end());
        const int minVal = *pmin, maxVal = *pmax;
        const int n = nums.size();
        const int d = max(1, (maxVal - minVal) / (n - 1));
        const int bucketSize = (maxVal - minVal) / d + 1;
        vector<pair<int, int>> bucket(bucketSize, {-1, -1});
        for (int it : nums)
        {
            int i = (it - minVal) / d;
            if (bucket[i].first == -1)
            {
                bucket[i].first = bucket[i].second = it;
            }
            else
            {
                bucket[i].first = min(bucket[i].first, it);
                bucket[i].second = max(bucket[i].second, it);
            }
        }

        int prev = -1, ret = 0;
        for (int i = 0; i < bucketSize; i++)
        {
            if (bucket[i].first == -1)
                continue;
            if (prev != -1)
            {
                ret = max(ret, bucket[i].first - bucket[prev].second);
            }
            prev = i;
        }
        return ret;
    }
};