#include <vector>
#include <iostream>

using namespace std;

class Solution
{
public:
    vector<int> path;
    vector<vector<int>> ret;
    vector<vector<int>> combine(int n, int k)
    {
        dfs(1, n, k);
        return ret;
    }

    void dfs(int i, int n, int k)
    {
        if (path.size() + n + 1 - i < k)
            return;
        if (path.size() == k)
        {
            ret.push_back(path);
            return;
        }
        path.push_back(i);
        dfs(i + 1, n, k);
        path.pop_back();
        dfs(i + 1, n, k);
    }
};

int main(int argc, char const *argv[])
{
    cout << "combinations!" << endl;
    return 0;
}
