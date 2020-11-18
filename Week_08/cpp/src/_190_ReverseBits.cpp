#include <vector>
using namespace std;
class Solution
{
public:
    uint32_t reverseBits(uint32_t n)
    {
        uint32_t ret = 0;
        int power = 31;
        while (power >= 0)
        {
            ret |= (n & 1) << power;
            n >>= 1;
            power--;
        }
        return ret;
    }
};