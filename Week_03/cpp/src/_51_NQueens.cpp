#include <vector>
#include <iostream>
#include <string>

using namespace std;

class Solution
{
public:
    vector<int> queens;
    vector<vector<string>> ret;
    int n;
    int mask;
    vector<vector<string>> solveNQueens(int n)
    {
        if (n < 1)
            return ret;
        this->n = n;
        mask = (1 << n) - 1;
        dfs(0, 0, 0, 0);
        return ret;
    }

    void dfs(int i, int col, int pie, int na)
    {
        if (i == n)
        {
            generateSolution();
            return;
        }
        auto positions = ~(col | pie | na) & mask;
        while (positions)
        {
            auto p = positions & -positions;
            queens.push_back(__builtin_ctz(p));
            dfs(i + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            queens.pop_back();
            positions = positions & positions - 1;
        }
    }

    void generateSolution()
    {
        auto board = vector<string>();
        for (auto i = 0; i < n; i++)
        {
            auto row = string(n, '.');
            row[queens[i]] = 'Q';
            board.push_back(row);
        }
        ret.push_back(board);
    }
};

int main(int argc, char const *argv[])
{
    cout << "hi queens" << endl;
    return 0;
}
