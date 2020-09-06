#include <vector>
#include <queue>
#include <iostream>

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
    vector<vector<int>> levelOrderBottom(TreeNode *root)
    {
        vector<vector<int>> ret;
        if (!root)
            return ret;
        queue<TreeNode *> q;
        q.push(root);
        while (!q.empty())
        {
            vector<int> list;
            int size = q.size();
            while (size-- > 0)
            {
                auto node = q.front();
                q.pop();
                list.push_back(node->val);
                if (node->left)
                    q.push(node->left);
                if (node->right)
                    q.push(node->right);
            }
            ret.push_back(list);
        }
        reverse(ret.begin(), ret.end());
        return ret;
    }
};
class Dfs
{
public:
    vector<vector<int>> levelOrderBottom(TreeNode *root)
    {
        vector<vector<int>> ret;
        dfs(root, 0, ret);
        reverse(ret.begin(), ret.end());
        return ret;
    }
    void dfs(TreeNode *root, int level, vector<vector<int>> &ret)
    {
        if (!root)
            return;
        if (level == ret.size())
            ret.push_back(vector<int>());
        ret[level].push_back(root->val);
        dfs(root->left, level + 1, ret);
        dfs(root->right, level + 1, ret);
    }
};
int main(int argc, char const *argv[])
{
    cout << "hi" << endl;
    return 0;
}
