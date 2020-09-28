#include <vector>
using namespace std;
class Solution
{
public:
    bool canJump(vector<int> &nums)
    {
        int rightMost = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if (i > rightMost)
                return false;
            rightMost = max(i + nums[i], rightMost);
        }
        return true;
    }
};