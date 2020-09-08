#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>

using namespace std;

class UsingHeap
{
public:
    static bool cmp(pair<int, int> &l, pair<int, int> &r)
    {
        return l.second > r.second;
    }
    vector<int> topKFrequent(vector<int> &nums, int k)
    {
        unordered_map<int, int> table;
        for (auto &v : nums)
        {
            table[v]++;
        }
        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(&cmp)> heap(cmp);
        for (auto &[v, count] : table)
        {
            if (heap.size() < k)
            {
                heap.emplace(v, count);
            }
            else
            {
                if (heap.top().second < count)
                {
                    heap.pop();
                    heap.emplace(v, count);
                }
            }
        }
        vector<int> ret(k);
        for (int i = 0; i < k; i++)
        {
            ret[i] = heap.top().first;
            heap.pop();
        }
        return ret;
    }
};

int main(int argc, char const *argv[])
{
    cout << "top k frequent elements" << endl;
    return 0;
}
