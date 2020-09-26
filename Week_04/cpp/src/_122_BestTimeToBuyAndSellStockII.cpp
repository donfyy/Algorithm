#include <vector>
using namespace std;
class UsingGreedy
{
public:
    // O(n) O(1)
    int maxProfit(vector<int> &prices)
    {
        int ret = 0;
        int n = prices.size();
        if (!n)
            return ret;
        for (int i = 1; i < n; i++)
        {
            ret += max(0, prices[i] - prices[i - 1]);
        }
        return ret;
    }
};