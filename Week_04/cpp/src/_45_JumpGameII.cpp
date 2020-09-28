#include <vector>
using namespace std;
class UsingGreedy
{
public:
    // step: 已经跳过的次数
    // stepPos: 上一次可跳到的最远位置
    // maxPos: 当前这一步可跳到的最远位置
    int jump(vector<int> &nums)
    {
        int n = nums.size(), step = 0, stepPos = 0, maxPos = 0;
        for (int i = 0; i < n - 1; i++)
        {
            maxPos = max(maxPos, i + nums[i]);
            if (i == stepPos)
            {
                stepPos = maxPos;
                step++;
            }
        }
        return step;
    }
};