#include <vector>
#include <iostream>

using namespace std;

class 纵
{
public:
    vector<int> path;
    vector<vector<int>> ret;
    vector<vector<int>> combine(int n, int k)
    {
        dfs(1, n, k);
        return ret;
    }
    // 时间O((n, k) * k) 空间O(n)
    void dfs(int i, int n, int k)
    {
        if (n + 1 - i < k)
            return;
        if (k == 0)
        {
            ret.push_back(path);
            return;
        }
        path.push_back(i);
        dfs(i + 1, n, k - 1);
        path.pop_back();
        dfs(i + 1, n, k);
    }
};
class 横
{
public:
    vector<vector<int>> ret;
    vector<int> path;
    // 时间O((n,k) * k) 空间O(k)
    vector<vector<int>> combine(int n, int k)
    {
        dfs(1, n, k);
        return ret;
    }
    void dfs(int start, int n, int k)
    {
        if (k == 0)
        {
            ret.push_back(path);
            return;
        }
        if (n + 1 - start < k)
            return;
        k--;
        for (int i = start; i <= n; i++)
        {
            path.push_back(i);
            dfs(i + 1, n, k);
            path.pop_back();
        }
    }
};
int main(int argc, char const *argv[])
{
    cout << "combinations!" << endl;
    return 0;
}
