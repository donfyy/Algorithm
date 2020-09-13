#include <vector>
#include <iostream>
#include <string>

using namespace std;

class UsingBinarySearch
{
public:
    int breakfastNumber(vector<int> &staple, vector<int> &drinks, int x)
    {
        sort(staple.begin(), staple.end());
        sort(drinks.begin(), drinks.end());
        const int Q = 1000000007;
        int ret = 0;
        for (int i = 0; i < staple.size(); i++)
        {
            int l = 0, r = drinks.size(), t = x - staple[i];
            while (l < r)
            {
                int m = l + ((r - l) >> 1);
                if (drinks[m] <= t)
                    l = m + 1;
                else
                    r = m;
            }
            if (l == 0)
                break;
            ret = (ret + l) % Q;
        }
        return ret;
    }
};

int main(int argc, char const *argv[])
{
    cout << "早餐组合" << endl;
    return 0;
}
