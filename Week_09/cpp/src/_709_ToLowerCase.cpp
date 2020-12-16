#include <string>
using namespace std;
class Solution
{
public:
    string toLowerCase(string str)
    {
        /* 位运算（解题区的思路
        大写变小写、小写变大写 : 字符 ^= 32;
        大写变小写、小写变小写 : 字符 |= 32;  
        小写变大写、大写变大写 : 字符 &= -33;
        eg：
        65(A)->二进制表示为100 0001
        32的二进制表示为 010 0000 
        100 0001|010 0000=110 0001->97(a)
        */
        for (auto &it : str)
        {
            it |= 32;
        }
        return str;
    }
};