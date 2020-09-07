#include <vector>
#include <stack>

using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class InorderMorris
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

class InorderIterative
{
public:
    vector<int> inorderTraversal(TreeNode *root)
    {
        vector<int> ret;
        stack<TreeNode *> st;
        while (root || !st.empty())
        {
            while (root)
            {
                st.push(root);
                root = root->left;
            }
            root = st.top();
            st.pop();
            ret.push_back(root->val);
            root = root->right;
        }
        return ret;
    }
};

/**
 * 每个节点都会入栈两次，效率并不高
 */
class InorderIterative2
{
public:
    vector<int> inorderTraversal(TreeNode *root)
    {
        vector<int> ret;
        stack<TreeNode *> st;
        if (root)
            st.push(root);
        while (!st.empty())
        {
            root = st.top();
            if (root)
            {
                st.pop();
                if (root->right)
                    st.push(root->right);
                st.push(root);
                st.push(nullptr);
                if (root->left)
                    st.push(root->left);
            }
            else
            {
                st.pop();
                root = st.top();
                st.pop();
                ret.push_back(root->val);
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
