#include <vector>
using namespace std;
class UsingBinarySearch2
{
public:
    vector<int> searchRange(vector<int> &nums, int target)
    {
        // 查找第一个大于等于target的数或者第一个大于target的数
        auto search = [&](bool lower) -> int {
            int l = 0, r = nums.size() - 1, ret = nums.size();
            while (l <= r)
            {
                int m = l + ((r - l) >> 1);
                if (target < nums[m] || (lower && target <= nums[m]))
                {
                    r = m - 1;
                    ret = m;
                }
                else
                {
                    l = m + 1;
                }
            }
            return ret;
        };
        int leftIdx = search(true), rightIdx = search(false) - 1;
        if (leftIdx < nums.size() && nums[leftIdx] == target)
        {
            return {leftIdx, rightIdx};
        }
        return {-1, -1};
    }
};
class UsingBinarySearch1
{
public:
    vector<int> searchRange(vector<int> &nums, int target)
    {
        // 查找左右两个端点，代码显得冗长
        auto endPoint = [&](bool isLeft) -> int {
            int l = 0, r = nums.size() - 1, ret = -1;
            while (l <= r)
            {
                int m = l + ((r - l) >> 1);
                if (target < nums[m])
                {
                    r = m - 1;
                }
                else if (nums[m] < target)
                {
                    l = m + 1;
                }
                else
                {
                    if (isLeft)
                    {
                        if (m > l && nums[m - 1] == target)
                        {
                            r = m - 1;
                            continue;
                        }
                    }
                    else
                    {
                        if (m < r && nums[m + 1] == target)
                        {
                            l = m + 1;
                            continue;
                        }
                    }
                    ret = m;
                    break;
                }
            }
            return ret;
        };
        int left = endPoint(true);
        if (left == -1)
            return {-1, -1};
        return {left, endPoint(false)};
    }
};