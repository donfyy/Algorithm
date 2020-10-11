#include <vector>
#include <iostream>
using namespace std;
int partition(vector<int> &nums, int start, int end)
{
    int pivot = end;
    int j = start - 1;
    for (int i = start; i < end; i++) {
        if (nums[i] < nums[pivot]) {
            swap(nums[i], nums[++j]);
        }
    }  
    swap(nums[pivot], nums[++j]);
    return j;
}
void quickSort(vector<int> &nums, int start, int end) {
    if (start >= end) return;
    int pivot = partition(nums, start, end);
    quickSort(nums, start, pivot - 1);
    quickSort(nums, pivot + 1, end);
}
int main(int argc, char const *argv[])
{
    vector<int> array = {1, 5, 3, 2, 6, 4};
    quickSort(array, 0, array.size() - 1);
    cout << "[";
    for (int i = 0; i < array.size(); i++)
    {
        cout << array[i] << ",";
    }
    cout << "]" << endl;
    return 0;
}
