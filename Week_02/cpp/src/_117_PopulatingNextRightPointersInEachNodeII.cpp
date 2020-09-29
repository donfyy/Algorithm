#include <vector>
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};

class Solution
{
public:
    // O(n) O(1)
    Node *connect(Node *root)
    {
        auto start = root, dummy = new Node(0);
        while (start)
        {
            Node *p = start, *pre = dummy;
            while (p)
            {
                if (p->left)
                {
                    pre->next = p->left;
                    pre = p->left;
                }
                if (p->right)
                {
                    pre->next = p->right;
                    pre = p->right;
                }
                p = p->next;
            }
            start = dummy->next;
            dummy->next = NULL;
        }
        delete dummy;
        return root;
    }
};