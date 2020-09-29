#include <vector>
using namespace std;
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
class UsingMorris
{
public:
    vector<int> postorderTraversal(TreeNode *root)
    {
        vector<int> ret;
        while (root)
        {
            if (!root->right)
            {
                ret.insert(ret.begin(), root->val);
                root = root->left;
            }
            else
            {
                auto p = root->right;
                while (p->left && p->left != root)
                {
                    p = p->left;
                }
                if (p->left == root)
                {
                    p->left = NULL;
                    root = root->left;
                }
                else
                {
                    p->left = root;
                    ret.insert(ret.begin(), root->val);
                    root = root->right;
                }
            }
        }
        return ret;
    }
};