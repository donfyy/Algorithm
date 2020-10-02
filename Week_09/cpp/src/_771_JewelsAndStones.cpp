#include <string>
using namespace std;
class Solution
{
public:
    // O(m + n) O(1)
    int numJewelsInStones(string J, string S)
    {
        int t[256] = {0}, ret = 0;
        for (char c : J)
            t[c] = 1;
        for (char c : S)
            if (t[c])
                ret++;
        return ret;
    }
};