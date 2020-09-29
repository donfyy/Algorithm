#include <vector>
#include <queue>
using namespace std;
  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
class UsingBfs
{
public:
    vector<int> rightSideView(TreeNode *root)
    {
        vector<int> ret;
        if (!root)
            return ret;
        queue<TreeNode *> q;
        q.push(root);
        while (!q.empty())
        {
            int size = q.size();
            while (size--)
            {
                auto n = q.front();
                q.pop();
                if (n->left)
                    q.push(n->left);
                if (n->right)
                    q.push(n->right);
                if (!size)
                    ret.push_back(n->val);
            }
        }
        return ret;
    }
};