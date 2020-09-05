#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> map;
        for (auto i = 0; i < nums.size(); i++) {
            auto b = target - nums[i];
            auto iter = map.find(b);
            if (iter != map.end()) {
                return {iter->second, i};
            }
            map[nums[i]] = i;
        }
        return {-1, -1};
    }
};

int main(int argc, char const *argv[])
{
    cout << "two sum!" << endl;
    return 0;
}
