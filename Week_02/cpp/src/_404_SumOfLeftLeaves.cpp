#include <iostream>
using namespace std;
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class UsingDfs
{
public:
    // O(n) O(logn)
    int sumOfLeftLeaves(TreeNode *root)
    {
        if (!root)
            return 0;
        return dfs(root, false);
    }
    int dfs(TreeNode *root, bool left)
    {
        if (!root->left && !root->right)
            return left ? root->val : 0;
        int ret = 0;
        if (root->left)
            ret += dfs(root->left, true);
        if (root->right)
            ret += dfs(root->right, false);
        return ret;
    }
};