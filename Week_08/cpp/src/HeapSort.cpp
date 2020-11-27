#include <vector>
#include <iostream>
using namespace std;
void siftDown(vector<int> &nums, int n, int k)
{
    int half = n >> 1, i = k, v = nums[i];
    while (i < half)
    {
        int child = (i << 1) + 1;
        int right = child + 1;
        if (right < n && nums[right] > nums[child])
        {
            child = right;
        }
        if (v >= nums[child])
            break;
        nums[i] = nums[child];
        i = child;
    }
    nums[i] = v;
}
void heapSort(vector<int> &nums)
{
    // O(nlogn) O(1)  不稳定
    const int n = nums.size();
    for (int i = (n >> 1) - 1; i >= 0; i--)
    {
        siftDown(nums, n, i);
    }
    for (int i = n - 1; i > 0; i--)
    {
        swap(nums[0], nums[i]);
        siftDown(nums, i, 0);
    }
}
int main(int argc, char const *argv[])
{
    vector<int> array = {1, 5, 3, 2, 6, 4};
    heapSort(array);
    cout << "[";
    for (int i = 0; i < array.size(); i++)
    {
        cout << array[i] << ",";
    }
    cout << "]" << endl;
    return 0;
}
