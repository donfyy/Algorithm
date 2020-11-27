#include <vector>
#include <iostream>
using namespace std;

void selectSort(vector<int> &nums)
{
    // O(n ^ 2) O(1) 不稳定
    const int n = nums.size();
    for (int i = 0; i < n - 1; i++)
    {
        int min = i;
        for (int j = i + 1; j < n; j++)
        {
            if (nums[j] < nums[min])
            {
                min = j;
            }
        }
        swap(nums[i], nums[min]);
    }
}
int main(int argc, char const *argv[])
{
    vector<int> nums = {1, 5, 3, 2, 6, 4};
    selectSort(nums);
    cout << "[";
    for (int i = 0; i < nums.size(); i++)
    {
        cout << nums[i] << ",";
    }
    cout << "]" << endl;
    return 0;
}
