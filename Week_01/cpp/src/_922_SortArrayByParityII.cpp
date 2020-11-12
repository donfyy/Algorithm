#include <vector>
using namespace std;
class UsingTwoPointersWithPatition
{
public:
    vector<int> sortArrayByParity(vector<int> &A)
    {
        // 双指针
        const int n = A.size();
        for (int i = 0, j = -1; i < n; i++)
        {
            if (!(A[i] & 1))
            {
                swap(A[++j], A[i]);
            }
        }
        return A;
    }
};
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