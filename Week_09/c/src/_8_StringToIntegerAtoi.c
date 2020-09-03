#include <stdio.h>
#include <limits.h>

int myAtoi(char *s)
{
    if (s == NULL)
        return 0;
    int ret = 0;
    while (*s == ' ')
        s++;
    int sign = *s == '-' ? -1 : 1;
    if (*s == '+' || *s == '-')
    {
        s++;
    }
    while (*s >= '0' && *s <= '9')
    {
        int num = *s - '0';
        if (ret > INT_MAX / 10 || (ret == INT_MAX / 10 && num > INT_MAX % 10))
        {
            if (sign == 1)
                return INT_MAX;
            else
                return INT_MIN;
        }
        ret = ret * 10 + num;
        s++;
    }
    return ret * sign;
}