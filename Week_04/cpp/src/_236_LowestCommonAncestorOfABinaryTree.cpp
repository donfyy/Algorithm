#include <string>
#include <iostream>
#include <queue>

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
    TreeNode *ret;
    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        ret = NULL;
        dfs(root, p, q);
        return ret;
    }
    bool dfs(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        if (!root)
            return false;
        bool l = dfs(root->left, p, q);
        bool r = dfs(root->right, p, q);
        if (l && r || ((l || r) && (root == p || root == q)))
        {
            ret = root;
        }
        return l || r || root == p || root == q;
    }
};