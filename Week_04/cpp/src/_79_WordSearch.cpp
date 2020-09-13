#include <string>
#include <iostream>
#include <queue>

using namespace std;

class Dfs
{
public:
    vector<pair<int, int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    // 时间 O(mn*3^L) 空间 O(min(L, mn)) L表示单词的长度
    bool exist(vector<vector<char>> &board, string word)
    {
        for (int i = 0; i < board.size(); i++)
        {
            for (int j = 0; j < board[0].size(); j++)
            {
                if (dfs(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }
    bool dfs(vector<vector<char>> &board, int i, int j, string &path, int idx)
    {
        // if (idx == path.size()) return true;
        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size() || board[i][j] == '#' || board[i][j] != path[idx++])
            return false;
        if (idx == path.size())
            return true;
        char c = board[i][j];
        board[i][j] = '#';
        bool ret = false;
        for (auto &[di, dj] : dirs)
        {
            if (dfs(board, i + di, j + dj, path, idx))
            {
                ret = true;
                break;
            }
        }
        board[i][j] = c;
        return ret;
    }
};