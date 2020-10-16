#include <vector>
using namespace std;
class Solution
{
public:
    // 读懂题目的意思了，想到了归并，但是没有逆向思考。
    vector<int> sortedSquares(vector<int> &A)
    {
        int n = A.size(), i = 0, j = n - 1, k = j;
        vector<int> ret(n);
        while (i <= j)
        {
            if (A[i] * A[i] < A[j] * A[j])
            {
                ret[k--] = A[j] * A[j--];
            }
            else
            {
                ret[k--] = A[i] * A[i++];
            }
        }
        return ret;
    }
};