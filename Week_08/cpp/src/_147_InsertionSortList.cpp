struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
class Solution
{
public:
    ListNode *insertionSortList(ListNode *head)
    {
        if (!head)
            return head;
        ListNode *dummy = new ListNode(0), *tail = head, *p = head->next;
        dummy->next = head;
        while (p)
        {
            if (tail->val <= p->val)
            {
                tail = p;
            }
            else
            {
                auto q = dummy;
                while (q->next->val <= p->val)
                {
                    q = q->next;
                }
                tail->next = p->next;
                p->next = q->next;
                q->next = p;
            }
            p = tail->next;
        }
        p = dummy->next;
        delete dummy;
        return p;
    }
};