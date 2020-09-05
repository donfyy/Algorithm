#include <vector>
#include <string>
using namespace std;

class Solution
{
public:
    vector<string> binaryTreePaths(TreeNode *root)
    {
        vector<string> ret;
        dfs(root, "", ret);
        return ret;
    }
    void dfs(TreeNode *root, string path, vector<string> &ret)
    {
        if (!root)
            return;
        path += path.size() > 0 ? "->" + to_string(root->val) : to_string(root->val);
        if (!root->left && !root->right)
            ret.push_back(path);
        dfs(root->left, path, ret);
        dfs(root->right, path, ret);
    }
};

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};