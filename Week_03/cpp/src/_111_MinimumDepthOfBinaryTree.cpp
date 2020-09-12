#include <iostream>
using namespace std;
class Solution
{
public:
    int minDepth(TreeNode *root)
    {
        if (!root)
            return 0;
        int l = minDepth(root->left);
        int r = minDepth(root->right);
        return (l && r) ? min(l, r) + 1 : max(l, r) + 1;
    }
};
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};