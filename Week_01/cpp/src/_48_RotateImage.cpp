#include <vector>
using namespace std;
class Solution1
{
public:
    // O(n^2) O(n^2)
    void rotate(vector<vector<int>> &matrix)
    {
        const int n = matrix.size();
        auto matrixNew = matrix;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrixNew[j][n - 1 - i] = matrix[i][j];
            }
        }
        matrix = matrixNew;
    }
};
class Solution2
{
public:
    // O(n^2) O(1)
    // 应该如何旋转矩阵？
    // 应该枚举那些位置旋转矩阵？
    void rotate(vector<vector<int>> &matrix)
    {
        const int n = matrix.size();
        for (int i = 0; i< n >> 1; i++)
        {
            for (int j = 0; j<(n + 1) >> 1; j++)
            {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = t;
            }
        }
    }
};
class Solution3
{
public:
    // O(n^2) O(1)
    void rotate(vector<vector<int>> &matrix)
    {
        const int n = matrix.size();
        for (int i = 0; i<n> > 1; i++)
        {
            for (int j = 0; j < n; j++)
            {
                swap(matrix[i][j], matrix[n - 1 - i][j]);
            }
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                swap(matrix[i][j], matrix[j][i]);
            }
        }
    }
};