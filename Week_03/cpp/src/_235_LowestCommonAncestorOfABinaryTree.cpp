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
    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        if (!root || root == p || root == q)
            return root;
        if (p->val > q->val)
            swap(p, q);
        if (root->val < p->val)
            return lowestCommonAncestor(root->right, p, q);
        if (root->val > q->val)
            return lowestCommonAncestor(root->left, p, q);
        return root;
    }
};