#include <vector>
#include <queue>
using namespace std;
class Solution
{
public:
    // O(mn) O(mn)
    vector<vector<char>> updateBoard(vector<vector<char>> &board, vector<int> &click)
    {
        int i = click[0], j = click[1];
        if (board[i][j] == 'M')
        {
            board[i][j] = 'X';
            return board;
        }
        vector<pair<int, int>> dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        queue<pair<int, int>> q;
        q.push({i, j});
        int m = board.size(), n = board[0].size();
        while (!q.empty())
        {
            auto [i, j] = q.front();
            q.pop();
            int cnt = 0;
            for (auto &[di, dj] : dirs)
            {
                int u = di + i, v = dj + j;
                if (u >= 0 && u < m && v >= 0 && v < n && board[u][v] == 'M')
                {
                    cnt++;
                }
            }
            if (cnt)
            {
                board[i][j] = cnt + '0';
            }
            else
            {
                board[i][j] = 'B';
                for (auto &[di, dj] : dirs)
                {
                    int u = di + i, v = dj + j;
                    if (u >= 0 && u < m && v >= 0 && v < n && board[u][v] == 'E')
                    {
                        board[u][v] = 'B'; // 防止空方块被重复添加到队列中
                        q.push({u, v});
                    }
                }
            }
        }
        return board;
    }
};