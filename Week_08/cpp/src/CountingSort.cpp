#include <vector>
#include <iostream>
using namespace std;
void countingSort(vector<int> &nums)
{
    // 注意，修改nums的元素, *pmax是动态变化的
    const auto [pmin, pmax] = minmax_element(nums.begin(), nums.end());
    const int min = *pmin, max = *pmax;
    vector<int> bucket(max - min + 1, 0);
    for (int num : nums)
        bucket[num - min]++;
    int j = 0;
    for (int i = min; i <= max; i++)
    {
        int cnt = bucket[i - min];
        while (cnt-- > 0)
        {
            nums[j++] = i;
        }
    }
}
int main(int argc, char const *argv[])
{
    vector<int> nums = {1, 5, 3, 2, 2, 1, 3, 6, 4};
    countingSort(nums);
    cout << "[";
    for (int i = 0; i < nums.size(); i++)
    {
        cout << nums[i] << ",";
    }
    cout << "]" << endl;
    return 0;
}
