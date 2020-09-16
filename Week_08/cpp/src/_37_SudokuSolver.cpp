#include <vector>

using namespace std;

class Solution
{
public:
    int rows[9];
    int cols[9];
    int blocks[3][3];
    vector<pair<int, int>> spaces;
    void solveSudoku(vector<vector<char>> &board)
    {
        memset(rows, 0, sizeof(rows));
        memset(cols, 0, sizeof(cols));
        memset(blocks, 0, sizeof(blocks));

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] != '.')
                {
                    flip(i, j, board[i][j] - '0' - 1);
                }
            }
        }

        while (true)
        {
            bool find = false;
            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    int nums = ~(rows[i] | cols[j] || blocks[i / 3][j % 3]) & 0x1ff;
                    if (!(nums & nums - 1))
                    {
                        int num = __builtin_ctz(nums);
                        flip(i, j, num);
                        find = true;
                    }
                }
            }
            if (!find)
                break;
        }
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] == '.')
                {
                    spaces.emplace_back(i, j);
                }
            }
        }
        dfs(board, 0);
    }

    bool dfs(vector<vector<char>> &board, int idx)
    {
        if (idx == spaces.size())
            return true;
        auto [i, j] = spaces[idx];
        int nums = ~(rows[i] | cols[j] | blocks[i / 3][j / 3]) & 0x1ff;
        while (nums)
        {
            int num = __builtin_ctz(nums & -nums);
            flip(i, j, num);
            board[i][j] = num + '0' + 1;
            if (dfs(board, idx + 1))
                return true;
            flip(i, j, num);
            nums = nums & nums - 1;
        }
        return false;
    }

    void flip(int i, int j, int idx)
    {
        rows[i] ^= 1 << idx;
        cols[j] ^= 1 << idx;
        blocks[i / 3][j / 3] ^= 1 << idx;
    }
};