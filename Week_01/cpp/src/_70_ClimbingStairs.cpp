#include <iostream>

using namespace std;

class Solution
{
public:
    int climbStairs(int n)
    {
        // f(i) = f(i - 1) + f(i - 2)
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < n; i++)
        {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
};

int main(int argc, char const *argv[])
{
    cout << "2:" << Solution().climbStairs(2) << endl;
    return 0;
}
