#include <string>
using namespace std;
// 1.2020/10/01 ✅
// 2.2020/10/02 ✅
// 前缀和解法没读懂。。
class UsingDp
{
public:
    int minimumOperations(string leaves)
    {
        // f(i)(j) 表示从0到第i片叶子且第i片叶子处于状态j时所需要的最少调整次数
        // f(i)(0) = f(i - 1)(0) + isYellow(i)
        // f(i)(1) = min(f(i - 1)(0), f(i - 1)(1)) + isRed(i)
        // f(i)(2) = min(f(i - 1)(1), f(i - 1)(2)) + isYellow(i)
        // f(0)(0) = isYellow(0);
        int n = leaves.size();
        int p1 = leaves[0] == 'y', p2 = n, p3 = n;
        for (int i = 1; i < n; i++)
        {
            int isYellow = leaves[i] == 'y';
            int isRed = leaves[i] == 'r';
            int q1 = p1 + isYellow;
            int q2 = min(p1, p2) + isRed;
            int q3 = min(p2, p3) + isYellow;
            p1 = q1;
            p2 = q2;
            p3 = q3;
        }
        return p3;
    }
};