#include <vector>
using namespace std;
class Navie
{
public:
    int countPrimes(int n)
    {
        int ret = 0;
        auto isPrime = [](int x) -> bool {
            for (int i = 2; i * i <= x; i++)
            {
                if (x % i == 0)
                    return false;
            }
            return true;
        };
        for (int i = 2; i < n; i++)
        {
            if (isPrime(i))
                ret++;
        }
        return ret;
    }
};
class UsingEratostheness
{
public:
    // O(nloglogn) O(n)
    // 枚举没有考虑数与数之间的关联性
    // 如果x是质数，那么大于x的倍数 2x,3x...都是合数
    int countPrimes(int n)
    {
        vector<int> isPrime(n, 1);
        int ret = 0;
        for (int i = 2; i < n; i++)
        {
            if (isPrime[i])
            {
                ret++;
                for (long j = i; j * i < n; j++)
                {
                    isPrime[j * i] = 0;
                }
            }
        }
        return ret;
    }
};