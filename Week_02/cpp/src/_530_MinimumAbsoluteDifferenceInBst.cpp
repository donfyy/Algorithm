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
    int getMinimumDifference(TreeNode *root)
    {
        int ret = INT_MAX;
        TreeNode *pre = NULL;
        while (root)
        {
            if (!root->left)
            {
                calculate(&pre, &ret, root);
                root = root->right;
            }
            else
            {
                auto p = root->left;
                while (p->right && p->right != root)
                {
                    p = p->right;
                }
                if (!p->right)
                {
                    p->right = root;
                    root = root->left;
                }
                else
                {
                    p->right = NULL;
                    calculate(&pre, &ret, root);
                    root = root->right;
                }
            }
        }
        return ret;
    }
    void calculate(TreeNode **pre, int *ret, TreeNode *node)
    {
        if ((*pre))
        {
            *ret = min(*ret, abs(node->val - (*pre)->val));
        }
        (*pre) = node;
    }
};