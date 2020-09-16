double dfs(double, long long);
// 时间 O(logn) 空间 O(logn)
double myPow(double x, int n)
{
    if (x == 0)
        return 0;
    long long N = n < 0 ? -(long long)n : n;
    return n < 0 ? 1 / dfs(x, N) : dfs(x, N);
}
double dfs(double x, long long n)
{
    if (n == 0)
        return 1;
    return (n & 1) ? x * dfs(x * x, n >> 1) : dfs(x * x, n >> 1);
}

// 时间 O(logn) 空间 O(1)
double myPowIterative(double x, int n)
{
    if (x == 0)
        return 0;
    long long N = n < 0 ? -(long long)n : n;
    double ret = 1;
    // 假设n的二进制位为bmbm-1...b3b2b1
    // x^n = x^(2^m-1 * bm...2^2b3 * 2^1* b2*2^0*b1) = x
    while (N)
    {
        if (N & 1)
        {
            ret *= x;
        }
        x *= x;
        N >>= 1;
    }
    return n < 0 ? 1 / ret : ret;
}