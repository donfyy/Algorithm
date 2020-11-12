#include <vector>
using namespace std;
class UsingTwoPointers
{
public:
    vector<int> sortArrayByParityII(vector<int> &A)
    {
        const int n = A.size();
        if (n < 2)
            return A;
        // 双指针调整
        int i = 0, j = 1;
        while (i < n && j < n)
        {
            if (!(A[i] & 1))
            {
                i += 2;
            }
            else if (A[j] & 1)
            {
                j += 2;
            }
            else
            {
                swap(A[i], A[j]);
            }
        }
        return A;
    }
};