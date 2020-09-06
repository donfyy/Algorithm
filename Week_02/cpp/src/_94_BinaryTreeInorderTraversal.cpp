#include <vector>

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
    vector<int> inorderTraversal(TreeNode *root)
    {
        vector<int> ret;
        TreeNode *p;
        while (root)
        {
            if (!root->left)
            {
                ret.push_back(root->val);
                root = root->right;
            }
            else
            {
                p = root->left;
                while (p->right && p->right != root)
                {
                    p = p->right;
                }
                if (p->right)
                {
                    p->right = nullptr;
                    ret.push_back(root->val);
                    root = root->right;
                }
                else
                {
                    p->right = root;
                    root = root->left;
                }
            }
        }
        return ret;
    }
};

int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}
