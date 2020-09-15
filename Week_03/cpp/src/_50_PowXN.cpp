class Solution
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