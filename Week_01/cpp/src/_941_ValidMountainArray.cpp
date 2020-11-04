#include <vector>
using namespace std;
class SolutionMy
{
public:
    bool validMountainArray(vector<int> &A)
    {
        const int n = A.size();
        if (n < 3 || A[1] <= A[0])
            return false;
        bool increasing = true;
        for (int i = 2; i < n; i++)
        {
            if (A[i] == A[i - 1] || (!increasing && A[i] > A[i - 1]))
            {
                return false;
            }
            if (increasing && A[i] < A[i - 1])
            {
                increasing = false;
            }
        }
        return !increasing;
    }
};
class Naive
{
public:
    bool validMountainArray(vector<int> &A)
    {
        const int n = A.size() - 1;
        int i = 0;
        while (i < n && A[i] < A[i + 1])
            i++;
        if (i == 0 || i == n)
            return false;
        while (i < n && A[i] > A[i + 1])
            i++;
        return i == n;
    }
};