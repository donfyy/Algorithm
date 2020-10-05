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
    // 逐位计算并考虑进位值
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        ListNode head(0), *p = &head;
        int add = 0, a;
        while (l1 || l2 || add)
        {
            a = 0 + add;
            if (l1)
            {
                a += l1->val;
                l1 = l1->next;
            }
            if (l2)
            {
                a += l2->val;
                l2 = l2->next;
            }
            p->next = new ListNode(a % 10);
            p = p->next;
            add = a / 10;
        }
        return head.next;
    }
};