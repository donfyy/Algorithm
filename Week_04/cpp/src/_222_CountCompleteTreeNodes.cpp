struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};
class UsingBinarySearch
{
public:
    // O((logn)^2) O(1)
    // 完全二叉树的叶子结点可以由h个二进制位编码，非常妙
    // 我对树的思考还是不合格，没有想到左子树的节点数和右子树的节点数之间的关系。
    int countNodes(TreeNode *root)
    {
        if (!root)
            return 0;
        auto node = root;
        int level = 0;
        while (node->left)
        {
            level++;
            node = node->left;
        }
        if (!level)
            return 1;
        int l = 1 << level, r = 1 << (level + 1);
        while (l < r)
        {
            int m = l + ((r - l) >> 1);
            if (exists(root, level, m))
            {
                l = m + 1;
            }
            else
            {
                r = m;
            }
        }
        return l - 1;
    }

    bool exists(TreeNode *root, int level, int k)
    {
        int currLevel = 1 << (level - 1);
        while (currLevel)
        {
            if (currLevel & k)
            {
                root = root->right;
            }
            else
            {
                root = root->left;
            }
            currLevel >>= 1;
        }
        return root;
    }
};