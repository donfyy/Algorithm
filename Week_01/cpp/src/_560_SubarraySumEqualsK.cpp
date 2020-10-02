#include <vector>
#include <unordered_map>
using namespace std;
// 1.2020/10/02
class Solution
{
public:
    // O(n) O(n) 哈希表+前缀和
    // 将求和为k的连续子数组个数转换为求差为k的前缀和
    int subarraySum(vector<int> &nums, int k)
    {
        unordered_map<int, int> t;
        int cnt = 0, n = nums.size(), sum = 0;
        t[0] = 1;
        for (int i = 0; i < n; i++)
        {
            sum += nums[i];
            if (t.count(sum - k))
                cnt += t[sum - k];
            t[sum]++;
        }
        return cnt;
    }
};