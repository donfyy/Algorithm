#include <vector>
#include <queue>
using namespace std;
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class Bfs
{
public:
    vector<vector<int>> levelOrder(TreeNode *root)
    {
        vector<vector<int>> ret;
        queue<TreeNode *> q;
        if (root)
            q.push(root);
        while (!q.empty())
        {
            int size = q.size();
            vector<int> row;
            while (size-- > 0)
            {
                auto n = q.front();
                q.pop();
                row.push_back(n->val);
                if (n->left)
                    q.push(n->left);
                if (n->right)
                    q.push(n->right);
            }
            ret.push_back(row);
        }
        return ret;
    }
};