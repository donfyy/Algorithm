class Solution
{
public:
    int totalNQueens(int n)
    {
        int ret = 0;
        dfs(0, n, 0, 0, 0, &ret);
        return ret;
    }
    void dfs(int row, int n, int col, int pie, int na, int *ret)
    {
        if (row == n)
        {
            ++(*ret);
            return;
        }
        int pos = ~(col | pie | na) & ((1 << n) - 1);
        while (pos)
        {
            int p = pos & -pos;
            dfs(row + 1, n, col | p, (pie | p) << 1, (na | p) >> 1, ret);
            pos = pos & pos - 1;
        }
    }
};