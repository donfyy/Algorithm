#include <string>
#include <limits.h>
using namespace std;
class Solution
{
public:
    int myAtoi(string s)
    {
        const int n = s.size();
        int idx = 0;
        while (idx < n && s[idx] == ' ')
            idx++;
        if (idx == n)
            return 0;
        int sign = s[idx] == '-' ? -1 : 1;
        if (s[idx] == '-' || s[idx] == '+')
            idx++;
        int ret = 0;
        while (idx < n && s[idx] >= '0' && s[idx] <= '9')
        {
            int num = s[idx] - '0';
            if (ret > INT_MAX / 10 || (ret == INT_MAX / 10 && num > INT_MAX % 10))
            {
                return sign == -1 ? INT_MIN : INT_MAX;
            }
            ret = ret * 10 + num;
            idx++;
        }
        return ret * sign;
    }
};