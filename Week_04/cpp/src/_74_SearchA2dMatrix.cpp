#include <vector>
using namespace std;
class UsingBinarySearch1
{
public:
    bool searchMatrix(vector<vector<int>> &matrix, int t)
    {
        if (matrix.empty() || matrix[0].empty())
            return false;
        int n = matrix[0].size(), l = 0, r = matrix.size() * n - 1;
        while (l <= r)
        {
            int m = l + ((r - l) >> 1);
            int v = matrix[m / n][m % n];
            if (v == t)
                return true;
            if (t < v)
                r = m - 1;
            else
                l = m + 1;
        }
        return false;
    }
};
class UsingExclusion
{
public:
    // O(m + n)
    bool searchMatrix(vector<vector<int>> &matrix, int t)
    {
        if (matrix.empty() || matrix[0].empty())
            return false;
        int m = matrix.size(), n = matrix[0].size();
        int row = 0, col = n - 1;
        while (row < m && col >= 0)
        {
            int v = matrix[row][col];
            if (v == t)
                return true;
            if (v < t)
                row++;
            else
                col--;
        }
        return false;
    }
};