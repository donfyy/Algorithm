#include <vector>
using namespace std;
class GreedyWithSort
{
public:
    int largestPerimeter(vector<int> &A)
    {
        // 对数组排序
        // 从后向前选择第一个能够形成三角形的长度为3的连续子数组，也就是最长的周长
        const int n = A.size();
        if (n < 3)
            return 0;
        sort(A.begin(), A.end());
        for (int i = n - 1; i > 1; i--)
        {
            if (A[i - 1] + A[i - 2] > A[i])
            {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }
};