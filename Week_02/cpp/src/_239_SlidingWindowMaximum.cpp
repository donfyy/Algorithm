#include <vector>
#include <deque>
#include <iostream>

using namespace std;

class Deck
{
public:
    // 时间O(n) 空间O(k)
    // C++ 的priority_queue不支持删除指定的元素
    vector<int> maxSlidingWindow(vector<int> &nums, int k)
    {
        if (k > nums.size())
            return vector<int>(0);
        vector<int> ret(nums.size() - k + 1);
        deque<int> deq;
        for (int i = 0; i < k; i++)
        {
            while (!deq.empty() && nums[deq.back()] < nums[i])
                deq.pop_back();
            deq.push_back(i);
        }
        ret[0] = nums[deq.front()];
        for (int i = k; i < nums.size(); i++)
        {
            while (!deq.empty() && nums[deq.back()] < nums[i])
                deq.pop_back();
            deq.push_back(i);
            if (i - deq.front() == k)
                deq.pop_front();
            ret[i - k + 1] = nums[deq.front()];
        }
        return ret;
    }
};

int main(int argc, char const *argv[])
{
    cout << "sliding window maximum!" << endl;
    return 0;
}
