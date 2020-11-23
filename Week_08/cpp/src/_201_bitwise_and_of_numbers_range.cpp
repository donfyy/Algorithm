#include <iostream>

using namespace std;

class Solution
{
public:
    int rangeBitwiseAnd(int m, int n)
    {
        // 要求[m, n]这个范围内所有数字的按位与
        // 也就是要求这些数字的二进制位最长公共前缀
        // 也就是要求m与n的二进制位的最长公共前缀
        // 基于此直观的解法就是让m与n一起右移直到相等，并记录右移的位数cnt
        // 然后将结果左移cnt位即得解
        // 要求最长公共前缀，也就是要将非最长公共前缀的位变为0
        // 基于bk算法也就是 n1 = n & n - 1 可以清掉最低位的1
        // 那么就可以从n开始不断清掉最低位的1直到 n1 <= m
        while (n > m)
        {
            n &= n - 1;
        }
        return n;
    }
};