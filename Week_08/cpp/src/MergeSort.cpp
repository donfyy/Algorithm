#include <vector>
#include <iostream>
using namespace std;
void mergeSort(vector<int> &nums, int start, int end, vector<int> &temp)
{
    if (start >= end)
        return;
    int mid = start + ((end - start) >> 1);
    mergeSort(nums, start, mid, temp);
    mergeSort(nums, mid + 1, end, temp);

    int i = start, j = mid + 1, k = 0;
    while (i <= mid && j <= end)
    {
        temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
    }
    while (i <= mid)
    {
        temp[k++] = nums[i++];
    }
    while (j <= end)
    {
        temp[k++] = nums[j++];
    }
    copy(temp.begin(), temp.begin() + k, nums.begin() + start);
}
int main(int argc, char const *argv[])
{
    vector<int> array = {1, 5, 3, 2, 6, 4}, temp(array.size());
    mergeSort(array, 0, array.size() - 1, temp);
    cout << "[";
    for (int i = 0; i < array.size(); i++)
    {
        cout << array[i] << ",";
    }
    cout << "]" << endl;
    return 0;
}
