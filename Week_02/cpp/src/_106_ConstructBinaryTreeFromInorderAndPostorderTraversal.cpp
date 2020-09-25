#include <vector>
#include <unordered_map>
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
    unordered_map<int, int> inorderMap;

public:
    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder)
    {
        const int n = inorder.size();
        for (int i = 0; i < n; i++)
        {
            inorderMap[inorder[i]] = i;
        }
        return dfs(inorder, 0, n - 1, postorder, 0, n - 1);
    }
    TreeNode *dfs(vector<int> &inorder, int inorderStartIdx, int inorderEndIdx, vector<int> &postorder, int postorderStartIdx, int postorderEndIdx)
    {
        if (inorderStartIdx > inorderEndIdx)
            return NULL;
        auto ret = new TreeNode(postorder[postorderEndIdx]);
        int leftLen = inorderMap[ret->val] - inorderStartIdx;
        ret->left = dfs(inorder, inorderStartIdx, inorderStartIdx + leftLen - 1, postorder, postorderStartIdx, postorderStartIdx + leftLen - 1);
        ret->right = dfs(inorder, inorderStartIdx + leftLen + 1, inorderEndIdx, postorder, postorderStartIdx + leftLen, postorderEndIdx - 1);
        return ret;
    }
};