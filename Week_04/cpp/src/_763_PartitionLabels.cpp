#include <vector>
#include <string>
using namespace std;
class Solution
{
public:
    vector<int> partitionLabels(string S)
    {
        // 读到同一个字母只会出现在其中的一个片段，就不知道怎么划分了
        // 同一个字母只会出现在同一个片段，那这个字母第一次出现的下标位置 start和最后一次出现的下标位置 end
        // 一定在同一个片段中，所以要求出每个字母最后一次出现的下标位置。
        // 某个片段的结束位置也就是包含在其中的所有字母中最大的end。
        // 贪心算法和跳跃游戏类似
        const int n = S.size();
        vector<int> pos(26), ret;
        for (int i = 0; i < n; i++)
            pos[S[i] - 'a'] = i;
        int l = 0, r = 0;
        for (int i = 0; i < n; i++)
        {
            r = max(r, pos[S[i] - 'a']);
            if (i == r)
            {
                ret.push_back(r - l + 1);
                l = r + 1;
            }
        }

        return ret;
    }
};