#include <vector>
#include <unordered_map>

using namespace std;

class Solution
{
public:
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder)
    {
        unordered_map<int, int> table;
        for (int i = 0; i < inorder.size(); i++)
        {
            table[inorder[i]] = i;
        }

        return dfs(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1, table);
    }
    TreeNode *dfs(vector<int> &preorder, int pStart, int pEnd, vector<int> &inorder, int iStart, int iEnd, unordered_map<int, int> &table)
    {
        if (pStart > pEnd)
            return NULL;
        auto root = new TreeNode(preorder[pStart]);
        int idx = table[preorder[pStart]];
        int len = idx - iStart;
        root->left = dfs(preorder, pStart + 1, pStart + len, inorder, iStart, idx - 1, table);
        root->right = dfs(preorder, pStart + 1 + len, pEnd, inorder, idx + 1, iEnd, table);
        return root;
    }
};

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};