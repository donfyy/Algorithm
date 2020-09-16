#include <vector>
using namespace std;
class UsingDfsIncrement
{
public:
    // 时间 O(n * 2 ^ n) 空间 O(n)
    vector<vector<int>> subsets(vector<int> &nums)
    {
        vector<vector<int>> ret;
        vector<int> path;
        dfs(nums, 0, path, ret);
        return ret;
    }
    // 每一层子集的元素个数是相同的，长度为3的子集可以由长度为2的子集加上一个新的元素组成。
    void dfs(vector<int> &nums, int start, vector<int> &path, vector<vector<int>> &ret)
    {
        ret.push_back(path);
        for (int i = start; i < nums.size(); i++)
        {
            path.push_back(nums[i]);
            dfs(nums, i + 1, path, ret);
            path.pop_back();
        }
    }
};
class UsingBits
{
public:
    // O(2^n * n) O(1)
    vector<vector<int>> subsets(vector<int> &nums)
    {
        int n = nums.size(), max = 1 << n;
        vector<vector<int>> ret;
        for (int i = 0; i < max; i++)
        {
            vector<int> subset;
            for (int j = 0, k = i; j < n; j++, k >>= 1)
            {
                if (k & 1)
                {
                    subset.push_back(nums[j]);
                }
            }
            ret.push_back(subset);
        }
        return ret;
    }
};