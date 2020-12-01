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
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class UsingRecur
{
public:
    // O((logn)^2) O(logn)
    int countNodes(TreeNode *root)
    {
        if (!root)
            return 0;
        auto height = [](TreeNode *node) -> int {
            int ret = 0;
            while (node)
            {
                node = node->left;
                ret++;
            }
            return ret;
        };
        int l = height(root->left);
        int r = height(root->right);
        if (l == r)
            return (1 << l) + countNodes(root->right);
        return countNodes(root->left) + (1 << r);
    }
};

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class UsingBinarySearch2
{
public:
    int countNodes(TreeNode *root)
    {
        // 假设树的高度为h 则节点数在[2^(h - 1), 2^h)中
        // 注意到第k个节点（从1开始）的二进制位表示恰好是从跟节点到其的路径
        // 因此我们可以使用二分查找的方式找到完全二叉树的节点数
        int h = 0;
        auto node = root;
        while (node)
        {
            node = node->left;
            h++;
        }
        if (h < 2)
            return h;
        auto exists = [&](int k) -> bool {
            int level = 1 << (h - 2);
            auto node = root;
            while (level)
            {
                node = level & k ? node->right : node->left;
                level >>= 1;
            }
            return node;
        };
        int l = 1 << (h - 1), r = 1 << h;
        while (l < r)
        {
            int m = l + ((r - l) >> 1);
            if (exists(m))
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
};