struct TreeNode
{
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

int sumOfLeftLeaves(struct TreeNode *root)
{
    if (!root)
        return 0;
    int ret = 0;
    struct TreeNode *l = root->left;
    if (l)
    {
        if (!l->left && !l->right)
        {
            ret += l->val;
        }
        else
        {
            ret += sumOfLeftLeaves(l);
        }
    }
    return ret + sumOfLeftLeaves(root->right);
}