#include <vector>
#include <iostream>
using namespace std;
void insertSort(vector<int> &nums)
{
    // O(n^2) O(1) 稳定
    const int n = nums.size();
    for (int i = 1; i < n; i++)
    {
        int j = i - 1;
        int v = nums[i];
        while (j >= 0 && nums[j] > v)
        {
            nums[j + 1] = nums[j];
            j--;
        }
        nums[j + 1] = v;
    }
}
int main(int argc, char const *argv[])
{
    vector<int> array = {1, 5, 3, 2, 6, 4};
    insertSort(array);
    cout << "[";
    for (int i = 0; i < array.size(); i++)
    {
        cout << array[i] << ",";
    }
    cout << "]" << endl;
    return 0;
}
