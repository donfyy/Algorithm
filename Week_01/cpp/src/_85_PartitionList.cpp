struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};
class Solution
{
public:
    ListNode *partition(ListNode *head, int x)
    {
        ListNode dummy(0), *prej = &dummy, *prei = prej;
        dummy.next = head;
        while (prei->next)
        {
            if (prei->next->val < x)
            {
                if (prej != prei)
                {
                    auto t = prei->next;
                    prei->next = t->next;
                    t->next = prej->next;
                    prej->next = t;
                    prej = t;
                }
                else
                {
                    prej = prej->next;
                    prei = prei->next;
                }
            }
            else
            {
                prei = prei->next;
            }
        }
        return dummy.next;
    }
};