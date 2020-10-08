#include <iostream>
struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
class Solution
{
public:
    bool hasCycle(ListNode *head)
    {
        auto p = head, q = head;
        while (p && p->next)
        {
            p = p->next->next;
            q = q->next;
            if (p == q)
                return true;
        }
        return false;
    }
};