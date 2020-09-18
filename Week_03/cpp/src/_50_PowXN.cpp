class UsingRecursion
{
public:
    // 时间 O(logn) 空间 O(logn)
    double myPow(double x, int n)
    {
        long long N = n;
        return n < 0 ? 1 / dfs(x, -N) : dfs(x, N);
    }
    // 返回x的n次方
    double dfs(double x, long long n)
    {
        if (n == 0)
            return 1;
        return (n & 1) ? x * dfs(x * x, n >> 1) : dfs(x * x, n >> 1);
    }
};
class UsingIteration
{
public:
    double myPow(double x, int n)
    {
        long long N = n < 0 ? -(long long)n : n;
        auto ret = 1.0;
        while (N)
        {
            if (N & 1)
                ret *= x;
            x *= x;
            N >>= 1;
        }
        return n < 0 ? 1 / ret : ret;
    }
};