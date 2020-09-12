#include <iostream>
using namespace std;
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
    bool isValidBST(TreeNode *root)
    {
        long long prev = LONG_MIN;
        return dfs(root, &prev);
    }

    bool dfs(TreeNode *root, long long *prev)
    {
        if (!root)
            return true;
        if (!dfs(root->left, prev))
            return false;
        if (root->val <= *prev)
            return false;
        *prev = root->val;
        return dfs(root->right, prev);
    }
};