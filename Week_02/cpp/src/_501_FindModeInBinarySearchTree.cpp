#include <vector>
using namespace std;
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class UsingMorris
{
public:
    int maxFreq = 0, pre = 0, freq = 0;
    vector<int> ret;
    void update(int val)
    {
        if (val == pre)
        {
            freq++;
        }
        else
        {
            pre = val;
            freq = 1;
        }
        if (freq == maxFreq)
        {
            ret.push_back(pre);
        }
        if (freq > maxFreq)
        {
            ret.clear();
            ret.push_back(pre);
            maxFreq = freq;
        }
    }

    vector<int> findMode(TreeNode *root)
    {
        while (root)
        {
            if (!root->left)
            {
                update(root->val);
                root = root->right;
            }
            else
            {
                auto p = root->left;
                while (p->right && p->right != root)
                {
                    p = p->right;
                }
                if (p->right)
                {
                    update(root->val);
                    p->right = NULL;
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