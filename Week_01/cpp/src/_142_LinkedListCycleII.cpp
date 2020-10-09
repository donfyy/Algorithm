#include <vector>
struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
class Solution
{
public:
    ListNode *detectCycle(ListNode *head)
    {
        auto p = head, q = head;
        while (p && p->next)
        {
            p = p->next->next;
            q = q->next;
            if (p == q)
            {
                break;
            }
        }
        if (!p || !p->next)
            return NULL;
        p = head;
        while (p != q)
        {
            p = p->next;
            q = q->next;
        }
        return p;
    }
};