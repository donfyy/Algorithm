#include <vector>
#include <unordered_map>
#include <queue>
using namespace std;
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class UsingBfs
{
public:
    // O(n^2) O(n)
    // 采用bfs是为了练习记录每一个节点的父节点这个小技巧
    // 单词接龙ii要求生成所有的路径也用了类似的技巧，
    // 但单词接龙ii记录的是每一个单词的邻接单词。
    vector<vector<int>> pathSum(TreeNode *root, int sum)
    {
        vector<vector<int>> ret;
        if (!root)
            return ret;
        // 记录每一个节点的父节点
        unordered_map<TreeNode *, TreeNode *> t;
        queue<TreeNode *> q;
        queue<int> qs;
        q.push(root);
        qs.push(sum);
        while (!q.empty())
        {
            auto node = q.front();
            q.pop();
            auto rem = qs.front() - node->val;
            qs.pop();
            if (!node->left && !node->right)
            {
                if (!rem)
                {
                    getPath(ret, t, node);
                }
            }
            if (node->left)
            {
                t[node->left] = node;
                q.push(node->left);
                qs.push(rem);
            }
            if (node->right)
            {
                t[node->right] = node;
                q.push(node->right);
                qs.push(rem);
            }
        }
        return ret;
    }
    void getPath(vector<vector<int>> &ret, unordered_map<TreeNode *, TreeNode *> &t, TreeNode *node)
    {
        vector<int> path;
        while (node)
        {
            path.push_back(node->val);
            node = t[node];
        }
        reverse(path.begin(), path.end());
        ret.push_back(path);
    }
};