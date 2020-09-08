#include <iostream>
#include <queue>
#include <set>

using namespace std;

class UsingDp
{
public:
    // 时间O(n) 空间O(n)
    int nthUglyNumber(int n)
    {
        if (n < 1)
            return 0;
        int *nums = new int[n];
        nums[0] = 1;
        int *p2 = nums, *p3 = nums, *p5 = nums;
        for (int i = 1; i < n; i++)
        {
            nums[i] = min(*p2 * 2, min(*p3 * 3, *p5 * 5));
            while (*p2 * 2 <= nums[i])
                p2++;
            while (*p3 * 3 <= nums[i])
                p3++;
            while (*p5 * 5 <= nums[i])
                p5++;
        }
        int ret = nums[n - 1];
        delete[] nums;
        return ret;
    }
};

class UsingHeap
{
public:
    int nthUglyNumber(int n)
    {
        if (n < 1)
            return 0;
        priority_queue<long long, vector<long long>, greater<long long>> heap;
        set<long long> s;
        heap.push(1);
        int primes[] = {2, 3, 5};
        for (int i = 1; i < n; i++)
        {
            long long top = heap.top();
            heap.pop();
            for (int p : primes)
            {
                long long v = top * p;
                if (s.count(v) == 0)
                {
                    s.insert(v);
                    heap.push(v);
                }
            }
        }
        return heap.top();
    }
};

int main(int argc, char const *argv[])
{
    cout << "ugly number II" << endl;
    return 0;
}
