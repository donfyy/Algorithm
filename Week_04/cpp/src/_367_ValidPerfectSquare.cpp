class UsingNewtonMethod
{
public:
    bool isPerfectSquare(int num)
    {
        if (num < 0)
            return false;
        long long x = num;
        while (x * x > num)
            x = (x + num / x) >> 1;
        return x * x == num;
    }
};
class UsingBinarySearch
{
public:
    bool isPerfectSquare(int num)
    {
        if (num < 2)
            return true;
        int l = 0, r = num;
        while (l <= r)
        {
            long m = l + ((r - l) >> 1);
            if (m * m == num)
                return true;
            if (m * m > num)
                r = m - 1;
            else
                l = m + 1;
        }
        return false;
    }
};