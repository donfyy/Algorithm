int mySqrt(int c)
{
    long long x = c;
    while (x * x > c)
        x = (x + c / x) >> 1;
    return x;
}