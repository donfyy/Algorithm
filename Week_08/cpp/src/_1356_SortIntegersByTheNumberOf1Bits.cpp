#include <vector>
using namespace std;
class Solution
{
public:
    vector<int> sortByBits(vector<int> &arr)
    {
        vector<int> bits(10001);
        for (int i = 1; i < 10001; i++)
        {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        sort(arr.begin(), arr.end(), [&](int x, int y) {
            if (bits[x] < bits[y])
            {
                return true;
            }
            if (bits[x] > bits[y])
            {
                return false;
            }
            return x < y;
        });
        return arr;
    }
};