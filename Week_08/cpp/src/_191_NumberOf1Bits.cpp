#include <vector>
using namespace std;
class Solution
{
public:
    int hammingWeight(uint32_t n)
    {
        int ret = 0;
        while (n)
        {
            n = n & n - 1;
            ret++;
        }
        return ret;
    }
};