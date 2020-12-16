#include <string>
using namespace std;
class Solution
{
public:
    bool isNumber(string s)
    {
        const int n = s.size();
        int idx = 0;
        trim(s, &idx);
        bool numeric = scanInteger(s, &idx);
        if (idx < n && s[idx] == '.')
        {
            idx++;
            numeric = scanUnsignedInteger(s, &idx) || numeric;
        }
        if (idx < n && (s[idx] == 'e' || s[idx] == 'E'))
        {
            idx++;
            numeric = scanInteger(s, &idx) && numeric;
        }
        trim(s, &idx);
        return numeric && idx == n;
    }
    bool scanUnsignedInteger(string &s, int *idx)
    {
        const int preIdx = *idx, n = s.size();
        while (*idx < n && (s[*idx] >= '0' && s[*idx] <= '9'))
        {
            (*idx)++;
        }
        return *idx - preIdx;
    }

    bool scanInteger(string &s, int *idx)
    {
        if (*idx < s.size() && (s[*idx] == '+' || s[*idx] == '-'))
        {
            (*idx)++;
        }
        return scanUnsignedInteger(s, idx);
    }

    void trim(string &s, int *idx)
    {
        const int n = s.size();
        while (*idx < n && s[*idx] == ' ')
            (*idx)++;
    }
};