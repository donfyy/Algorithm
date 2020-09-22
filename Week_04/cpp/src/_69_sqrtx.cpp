class UsingBinarySearch
{
public:
    int mySqrt(int x)
    {
        if (x < 0)
            return -1;
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        int l = 1, r = x;
        while (l <= r)
        {
            int m = l + ((r - l) >> 1);
            int v = x / m;
            if (v == m)
                return v;
            if (v < m)
            {
                r = m - 1;
            }
            else
            {
                l = m + 1;
            }
        }
        return r;
    }
};