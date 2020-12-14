#include <unordered_set>
#include <vector>
using namespace std;
class UsingHashMap
{
public:
    bool containsDuplicate(vector<int> &nums)
    {
        unordered_set<int> s;
        for (int it : nums)
        {
            if (s.count(it))
                return true;
            s.insert(it);
        }
        return false;
    }
};