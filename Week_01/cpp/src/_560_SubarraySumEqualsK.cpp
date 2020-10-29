#include <vector>
#include <unordered_map>
using namespace std;
// 1.2020/10/02
// 2.2020/10/03
class Solution
{
public:
    // O(n) O(n) 哈希表+前缀和
    // 将求和为k的连续子数组个数转换为求差为k的前缀和
    int subarraySum(vector<int> &nums, int k)
    {
        // 将连续子数组的和转化为两个前缀和的差
        // 两个前缀和的差，又可以利用两数之和的思想
        // f(i) 前i个数的和
        // f(j) = f(i) - k  j in [0, i - 1]
        // 给定f(i) 查找f(j) = f(i) - k
        const int n = nums.size();
        int pre = 0, ret = 0;
        unordered_map<int, int> freq;
        freq[0] = 1;
        for (int i = 0; i < n; i++)
        {
            pre += nums[i];
            int other = pre - k;
            if (freq.count(other))
            {
                ret += freq[other];
            }
            freq[pre]++;
        }
        return ret;
    }
};