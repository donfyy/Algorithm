#include <vector>
#include <iostream>

using namespace std;

class 横
{
public:
    vector<vector<int>> ret;
    vector<int> path;
    // 重复出现的元素在第一次出现时被处理了，再次出现需要跳过。
    // 时间 O(n^n * n) 空间 O(n)
    vector<vector<int>> combinationSum2(vector<int> &candidates, int target)
    {
        sort(candidates.begin(), candidates.end());
        dfs(candidates, 0, target);
        return ret;
    }
    void dfs(vector<int> &candidates, int start, int target)
    {
        if (target == 0)
        {
            ret.push_back(path);
            return;
        }
        for (int i = start; i < candidates.size(); i++)
        {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            int v = candidates[i];
            if (target < v)
                return;
            path.push_back(v);
            dfs(candidates, i + 1, target - v);
            path.pop_back();
        }
    }

};
class 纵
{
public:
    vector<vector<int>> ret;
    vector<int> path;
    vector<vector<int>> freq;
    vector<vector<int>> combinationSum2(vector<int> &candidates, int target)
    {
        sort(candidates.begin(), candidates.end());
        for (int v : candidates)
        {
            if (freq.empty() || freq[freq.size() - 1][0] != v)
            {
                freq.push_back({v, 1});
            }
            else
            {
                freq[freq.size() - 1][1]++;
            }
        }
        dfs(0, target);
        return ret;
    }
    void dfs(int i, int target)
    {
        if (target == 0)
        {
            ret.push_back(path);
            return;
        }
        if (i == freq.size())
            return;
        dfs(i + 1, target);
        int most = min(target / freq[i][0], freq[i][1]);
        for (int j = 0; j < most; j++)
        {
            path.push_back(freq[i][0]);
            target -= freq[i][0];
            dfs(i + 1, target);
        }
        for (int j = 0; j < most; j++)
        {
            path.pop_back();
        }
    }
};