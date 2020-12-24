#include <stack>
#include <queue>
#include <deque>
#include <vector>
#include <unistd.h>

using namespace std;
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};
class MySolution
{
public:
    // O(n) O(n)
    // 按照节点遍历顺序打印值
    vector<vector<int>> zigzagLevelOrder(TreeNode *root)
    {
        if (!root)
            return {};
        vector<vector<int>> ret;
        stack<TreeNode *> s[2];
        int idx = 0;
        s[idx].push(root);
        while (!s[idx].empty())
        {
            auto &s1 = s[idx], &s2 = s[idx ^ 1];
            vector<int> level;
            while (!s1.empty())
            {
                auto node = s1.top();
                s1.pop();
                level.push_back(node->val);
                if (!idx)
                {
                    if (node->left)
                        s2.push(node->left);
                    if (node->right)
                        s2.push(node->right);
                }
                else
                {
                    if (node->right)
                        s2.push(node->right);
                    if (node->left)
                        s2.push(node->left);
                }
            }
            idx ^= 1;
            ret.push_back(level);
        }
        return ret;
    }
};
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution
{
public:
    // O(n) O(n)
    // 按照节点遍历顺序逆序打印值
    vector<vector<int>> zigzagLevelOrder(TreeNode *root)
    {
        if (!root)
            return {};
        vector<vector<int>> ret;
        bool isOrderLeft = true;
        queue<TreeNode *> q;
        q.push(root);
        while (q.size())
        {
            auto size = q.size();
            deque<int> level;
            while (size-- > 0)
            {
                auto node = q.front();
                q.pop();
                if (isOrderLeft)
                {
                    level.push_back(node->val);
                }
                else
                {
                    level.push_front(node->val);
                }
                if (node->left)
                    q.push(node->left);
                if (node->right)
                    q.push(node->right);
            }
            ret.push_back(vector<int>{level.begin(), level.end()});
            isOrderLeft = !isOrderLeft;
        }
        return ret;
    }
};
int main(int argc, char const *argv[])
{
    char *msg = "hi\n";
    write(1, msg, strlen(msg));
    return 0;
}
