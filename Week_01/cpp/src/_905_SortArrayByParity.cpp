#include <vector>
using namespace std;
class UsingTwoPointers
{
public:
    vector<int> sortArrayByParity(vector<int> &A)
    {
        // 双指针
        const int n = A.size();
        int i = 0, j = n - 1;
        while (i < j)
        {
            if (!(A[i] & 1))
            {
                i++;
            }
            else if (A[j] & 1)
            {
                j--;
            }
            else
            {
                swap(A[i], A[j]);
                i++;
                j--;
            }
        }
        return A;
    }
};