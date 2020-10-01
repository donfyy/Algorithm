#include <vector>
using namespace std;
class Bfs
{
public:
    void solve(vector<vector<char>> &board)
    {
        if (board.empty() || board[0].empty())
            return;
        int m = board.size(), n = board[0].size();
        for (int j = 0; j < n; j++)
        {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        for (int i = 1; i < m - 1; i++)
        {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    void dfs(vector<vector<char>> &board, int i, int j)
    {
        if (board[i][j] != 'O')
            return;
        board[i][j] = '#';
        vector<pair<int, int>> dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        for (auto &[dx, dy] : dirs)
        {
            int x = i + dx, y = j + dy;
            if (x >= 0 && x < board.size() && y >= 0 && y < board[0].size() && board[x][y] == 'O')
            {
                dfs(board, x, y);
            }
        }
    }
};