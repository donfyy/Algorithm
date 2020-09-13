#include <string>
#include <iostream>
#include <queue>

using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class CodecBfs
{
public:
    // Encodes a tree to a single string.
    string serialize(TreeNode *root)
    {
        queue<TreeNode *> q;
        string ret;
        q.push(root);
        while (!q.empty())
        {
            auto node = q.front();
            q.pop();
            if (node == nullptr)
            {
                ret += "$,";
            }
            else
            {
                ret += to_string(node->val) + ",";
                q.push(node->left);
                q.push(node->right);
            }
        }
        return ret;
    }
    bool readNumber(string &data, int *idx, int *num)
    {
        int i = *idx;
        bool isNumber = false;
        while (i < data.size() && data[i] != ',')
            i++;
        if (*idx < data.size() && data[*idx] != '$')
        {
            *num = stoi(data.substr(*idx, i - *idx));
            isNumber = true;
        }
        *idx = i + 1;
        return isNumber;
    }

    // Decodes your encoded data to tree.
    TreeNode *deserialize(string data)
    {
        int idx = 0;
        int num = 0;
        if (!readNumber(data, &idx, &num))
        {
            return nullptr;
        }
        auto root = new TreeNode(num);
        auto parent = root;
        TreeNode *node = nullptr;
        queue<TreeNode *> q;
        bool isLeft = true;
        while (idx != data.size())
        {
            node = nullptr;
            if (readNumber(data, &idx, &num))
            {
                node = new TreeNode(num);
                node->left = nullptr;
                node->right = nullptr;
                if (isLeft)
                    parent->left = node;
                else
                    parent->right = node;
            }

            isLeft = !isLeft;
            if (node)
                q.push(node);
            if (isLeft)
            {
                parent = q.front();
                q.pop();
            }
        }
        return root;
    }
};
class CodecDfs
{
public:
    bool readNum(string &s, int *idx, int *num)
    {
        int i = *idx;
        bool read = false;
        while (i < s.size() && s[i] != ',')
            i++;
        if (*idx < s.size() && s[*idx] != '$')
        {
            *num = stoi(s.substr(*idx, i - *idx));
            read = true;
        }
        *idx = i + 1;
        return read;
    }
    void dfs(TreeNode *root, string *s)
    {
        if (!root)
        {
            *s += "$,";
            return;
        }
        *s += to_string(root->val) + ",";
        dfs(root->left, s);
        dfs(root->right, s);
    }
    void dfs_(TreeNode **root, string &s, int *idx)
    {
        int num;
        if (readNum(s, idx, &num))
        {
            *root = new TreeNode(num);
            (*root)->left = NULL;
            (*root)->right = NULL;
            dfs_(&(*root)->left, s, idx);
            dfs_(&(*root)->right, s, idx);
        }
    }

    // Encodes a tree to a single string.
    string serialize(TreeNode *root)
    {
        string ret;
        dfs(root, &ret);
        return ret;
    }

    // Decodes your encoded data to tree.
    TreeNode *deserialize(string data)
    {
        // 一定要初始化自动变量
        int idx = 0;
        TreeNode *root = NULL;
        dfs_(&root, data, &idx);
        return root;
    }
};
