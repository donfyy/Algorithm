#include <vector>
using namespace std;
class UsingMath
{
public:
    // O(n)
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost)
    {
        // 从加油站x出发，假设最后可以到达的加油站是y，
        // 则从[x, y]内的任意一个加油站出发，都无法到达y的下一个加油站
        // 因此我们首先检查第0个加油站，判断能否环绕一周，如果不能则从第一个无法到达的加油站出发继续检查
        const int n = gas.size();
        int i = 0;
        while (i < n)
        {
            int cnt = 0, g = 0, c = 0;
            while (cnt < n)
            {
                int j = (i + cnt) % n;
                g += gas[j];
                c += cost[j];
                if (c > g)
                    break;
                cnt++;
            }
            if (cnt == n)
                return i;
            i = i + cnt + 1;
        }
        return -1;
    }
};