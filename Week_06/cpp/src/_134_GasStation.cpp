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
class UsingGraph
{
public:
    // 画图理解
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost)
    {
        // 从总油量剩余值最小的点出发，并且总油量剩余值大于等于0，即可环绕一周
        const auto n = gas.size();
        int spare = 0, minSpare = INT_MAX, idx;
        for (int i = 0; i < n; i++)
        {
            spare += gas[i] - cost[i];
            if (spare < minSpare)
            {
                minSpare = spare;
                idx = i;
            }
        }
        return spare < 0 ? -1 : (idx + 1) % n;
    }
};