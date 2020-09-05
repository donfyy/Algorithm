#include <vector>
#include <string>

using namespace std;

class Solution
{
public:
    string getPermutation(int n, int k)
    {
        vector<int> factorial(n);
        factorial[0] = 1;
        for (auto i = 1; i < n; i++)
        {
            factorial[i] = factorial[i - 1] * i;
        }
        k--;
        string ret;
        vector<int> valid(n + 1, 1);
        for (auto i = 1; i <= n; i++)
        {
            auto order = k / factorial[n - i] + 1;
            for (auto j = 1; j <= n; j++)
            {
                order -= valid[j];
                if (!order)
                {
                    ret += (j + '0');
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ret;
    }
};