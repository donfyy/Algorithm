#include <iostream>
#include <vector>
using namespace std;
class UsingPartition
{
public:
    // O(n) 修改了输入的数组
    int majorityElement(vector<int> &nums)
    {
        int start = 0, end = nums.size() - 1, mid = nums.size() / 2;
        int idx = partition(nums, start, end);
        while (idx != mid)
        {
            if (idx > mid)
                end = idx - 1;
            else
                start = idx + 1;
            idx = partition(nums, start, end);
        }
        return nums[idx];
    }

    int partition(vector<int> &nums, int start, int end)
    {
        if (start >= end)
            return end;
        int pivot = rand() % (end - start + 1) + start;
        swap(nums[pivot], nums[end]);
        pivot = start - 1;
        for (int i = start; i < end; i++)
        {
            if (nums[i] < nums[end])
                swap(nums[i], nums[++pivot]);
        }
        swap(nums[end], nums[++pivot]);
        return pivot;
    }
};