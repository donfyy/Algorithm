#include <iostream>

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class Solution
{
public:
    int sumNumbers(TreeNode *root)
    {
        if (!root)
            return 0;
        int ret = 0, path = 0;
        dfs(root, &ret, &path);
        return ret;
    }
    void dfs(TreeNode *root, int *ret, int *path)
    {
        *path = (*path) * 10 + root->val;
        if (root->left)
            dfs(root->left, ret, path);
        if (root->right)
            dfs(root->right, ret, path);
        if (!root->left && !root->right)
            *ret += *path;
        *path /= 10;
    }
};