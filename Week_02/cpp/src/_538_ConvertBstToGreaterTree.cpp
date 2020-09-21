#include <iostream>

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
    TreeNode *convertBST(TreeNode *root)
    {
        dfs(root, 0);
        return root;
    }

    int dfs(TreeNode *root, int sum)
    {
        if (!root)
            return sum;
        sum = dfs(root->right, sum);
        sum += root->val;
        root->val = sum;
        return dfs(root->left, sum);
    }
};