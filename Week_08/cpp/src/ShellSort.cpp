#include <vector>
#include <iostream>
using namespace std;
void shellSort(vector<int> &nums) {
    int n = nums.size();
    for (int gap = n >> 1; gap > 0; gap >>= 1) {
        for (int i = gap; i < n; i++) {
            int j = i - gap;
            int value = nums[i];
            while (j >= 0 && nums[j] > value) {
                nums[j + gap] = nums[j];
                j -= gap;
            }
            nums[j + gap] = value;
        }
    }
}
int main(int argc, char const *argv[])
{
    vector<int> array = {1, 5, 3, 2, 6, 4};
    shellSort(array);
    cout << "[";
    for (int i = 0; i < array.size(); i++)
    {
        cout << array[i] << ",";
    }
    cout << "]" << endl;
    return 0;
}
