#include <vector>
#include <iostream>
using namespace std;
void shellSort(vector<int> &nums) {
    for (int i = 1; i < nums.size(); i++) {
        int j = i - 1;
        int value = nums[i];
        while (j >= 0 && nums[j] > value) {
            nums[j + 1] = nums[j];
            j--;
        }
        nums[j + 1] = value;
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
