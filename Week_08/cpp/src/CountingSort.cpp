#include <vector>
#include <iostream>
using namespace std;
void countingSort(vector<int> &nums)
{
    int max = nums[0], n = nums.size();
    for (int i = 1; i < n; i++) {
        if (nums[i] > max) {
            max = nums[i];
        }
    }

    vector<int> bucket(max + 1);
    for (int i = 0; i < n; i++) {
        bucket[nums[i]]++;
    }
    for (int i = 0, j = 0; i <= max; i++) {
        int cnt = bucket[i];
        while (cnt-- > 0) {
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
