#include <vector>
#include <iostream>
using namespace std;
void radixSort(vector<int> &nums)
{
    // 找到最大元素，算出最大元素的十进制位个数
    const int bucketCount = 10, max = *max_element(nums.begin(), nums.end());
    int digitCount = 0;
    for (int i = max; i > 0; i /= 10)
        digitCount++;
    // 从低位到高位，按位对数组执行基数排序
    vector<vector<int>> buckets(bucketCount, vector<int>());
    for (int digit = 0, div = 1, mod = 10; digit < digitCount; digit++, div *= 10, mod *= 10)
    {
        for (int num : nums)
            buckets[num % mod / div].push_back(num);
        for (int i = 0, j = 0; i < bucketCount; i++)
        {
            auto bucket = buckets[i];
            sort(bucket.rbegin(), bucket.rend());
            while (!bucket.empty())
            {
                nums[j++] = bucket.back();
                bucket.pop_back();
            }
        }
    }
}
int main(int argc, char const *argv[])
{
    vector<int> nums = {1, 5, 3, 2, 2, 1, 3, 6, 4};
    radixSort(nums);
    cout << "[";
    for (int i = 0; i < nums.size(); i++)
    {
        cout << nums[i] << ",";
    }
    cout << "]" << endl;
    return 0;
}
