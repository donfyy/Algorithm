#include <vector>
using namespace std;
class Solution
{
public:
    int islandPerimeter(vector<vector<int>> &grid)
    {
        // 分别统计左视角和上视角的边
        const int m = grid.size(), n = grid[0].size();
        int ret = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j])
                {
                    ret += !i || !grid[i - 1][j];
                    ret += !j || !grid[i][j - 1];
                }
            }
        }
        return ret << 1;
    }
};
class Solution2
{
public:
    int islandPerimeter(vector<vector<int>> &grid)
    {
        // 统计每块陆地与水域或边界相邻的边
        const int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int ret = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j])
                {
                    for (const auto &dir : dirs)
                    {
                        int x = i + dir[0], y = j + dir[1];
                        if (x < 0 || x == m || y < 0 || y == n || !grid[x][y])
                        {
                            ret++;
                        }
                    }
                }
            }
        }
        return ret;
    }
};