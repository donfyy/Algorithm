#include <vector>
#include <iostream>

using namespace std;

class 横
{
public:
    vector<vector<int>> ret;
    vector<int> path;
    vector<vector<int>> combinationSum(vector<int> &candidates, int target)
    {
        dfs(candidates, 0, target);
        return ret;
    }
    // 通过 start 限制可以选择的元素范围去重
    // 时间 O(n^target * target) 空间 O(target)
    void dfs(vector<int> &candidates, int start, int target)
    {
        if (target < 0)
            return;
        if (target == 0)
        {
            ret.push_back(path);
            return;
        }
        for (int i = start; i < candidates.size(); i++)
        {
            int v = candidates[i];
            if (target - v < 0)
                continue;
            path.push_back(v);
            dfs(candidates, i, target - v);
            path.pop_back();
        }
    }
};

class 纵
{
public:
    vector<vector<int>> ret;
    vector<int> path;
    // 这里只会考虑在[i, n]之间未被考虑过的元素，因此不会产生重复解
    // 时间 O(2^target * target) 空间 O(target)
    vector<vector<int>> combinationSum(vector<int> &candidates, int target)
    {
        dfs(candidates, 0, target);
        return ret;
    }
    void dfs(vector<int> &candidates, int i, int target)
    {
        if (i == candidates.size())
            return;
        if (target == 0)
        {
            ret.push_back(path);
            return;
        }
        int v = candidates[i];
        if (target >= v)
        {
            path.push_back(candidates[i]);
            dfs(candidates, i, target - v);
            path.pop_back();
        }
        dfs(candidates, i + 1, target);
    }
};