#include <vector>
#include <iostream>
using namespace std;
void radixSort2(vector<int> &nums) {
    const int n = nums.size();
    const int maxVal = *max_element(nums.begin(), nums.end());
    vector<int> buf(n);
    for (int div = 1; div <= maxVal; div *= 10) {
        int cnt[10] = {0};
        for (int it : nums) {
            cnt[it / div % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            cnt[i] += cnt[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            buf[--cnt[nums[i] / div % 10]] = nums[i];
        }
        copy(buf.begin(), buf.end(), nums.begin());
    }
}
void radixSort(vector<int> &nums)
{
    // 找到最大元素，算出最大元素的十进制位个数
    const int bucketCount = 10, max = *max_element(nums.begin(), nums.end());
    // 从低位到高位，按位对数组执行基数排序
    vector<vector<int>> buckets(bucketCount, vector<int>());
    for (int div = 1; div <= max; div *= 10)
    {
        for (int it : nums) {
            buckets[it / div % 10].push_back(it);
        }
        int j = 0;
        for (auto &bucket : buckets)
        {
            // for (int it : bucket) {
            //     nums[j++] = it;
            // }
            // bucket.clear();
            while (!bucket.empty()) {
                nums[j++] = bucket.front();
                bucket.erase(bucket.begin());
            }
        }
    }
}
int main(int argc, char const *argv[])
{
    vector<int> nums = {1, 5, 3, 2, 2, 13, 3, 6, 4};
    radixSort2(nums);
    cout << "[";
    for (int i = 0; i < nums.size(); i++)
    {
        cout << nums[i] << ",";
    }
    cout << "]" << endl;
    return 0;
}
