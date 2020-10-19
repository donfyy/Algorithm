#include <vector>
#include <iostream>
using namespace std;
void bucketSort(vector<int> &nums)
{
    // 注意，修改nums的元素, *pmax是动态变化的
    const auto [pmin, pmax] = minmax_element(nums.begin(), nums.end());
    const int min = *pmin, max = *pmax;
    const int bucketSize = 3, bucketCount = (max - min) / bucketSize + 1;
    // 创建桶
    vector<vector<int>> buckets(bucketCount, vector<int>());
    // 将元素映射到桶中
    for (int num : nums)
        buckets[(num - min) / bucketSize].push_back(num);
    // 对每一个桶中的元素进行排序，然后取出桶中的元素
    for (int i = 0, j = 0; i < bucketCount; i++)
    {
        auto bucket = buckets[i];
        sort(bucket.begin(), bucket.end());
        for (int v : bucket)
        {
            nums[j++] = v;
        }
    }
}
int main(int argc, char const *argv[])
{
    vector<int> nums = {1, 5, 3, 2, 2, 1, 3, 6, 4};
    bucketSort(nums);
    cout << "[";
    for (int i = 0; i < nums.size(); i++)
    {
        cout << nums[i] << ",";
    }
    cout << "]" << endl;
    return 0;
}
