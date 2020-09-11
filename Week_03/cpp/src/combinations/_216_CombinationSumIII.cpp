#include <vector>
#include <iostream>

using namespace std;

class 横
{
public:
    vector<vector<int>> ret;
    vector<int> path;
    // 时间O(1) 空间O(1) 通过在候选数组中，用一个数丢弃一个数的方式
    // 来保证组合中不存在重复的数字同时也保证了不存在重复组合,因为候选数组中不存在重复数字。
    vector<vector<int>> combinationSum3(int k, int n)
    {
        dfs(1, n, k);
        return ret;
    }
    void dfs(int start, int n, int k)
    {
        if (k == 0 && n == 0)
        {
            ret.push_back(path);
            return;
        }
        k--;
        for (int i = start; i <= 9; i++)
        {
            if (i > n)
                return;
            path.push_back(i);
            dfs(i + 1, n - i, k);
            path.pop_back();
        }
    }
};
class 纵
{
public:
    vector<vector<int>> ret;
    vector<int> path;
    vector<vector<int>> combinationSum3(int k, int n)
    {
        dfs(1, n, k);
        return ret;
    }
    void dfs(int i, int n, int k)
    {
        if (k == 0 && n == 0)
        {
            ret.push_back(path);
            return;
        }
        if (k == 0 || i > 9 || i > n)
            return;
        path.push_back(i);
        dfs(i + 1, n - i, k - 1);
        path.pop_back();
        dfs(i + 1, n, k);
    }
};