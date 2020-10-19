struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
class Solution
{
public:
    ListNode *removeNthFromEnd(ListNode *head, int n)
    {
        ListNode dummy = ListNode(0, head), *q = &dummy, *p = head;
        // p先走n步
        for (int i = 0; i < n; i++)
        {
            p = p->next;
        }
        // q和p一起走，直到p为null, q的next就是要删除的节点
        while (p)
        {
            p = p->next;
            q = q->next;
        }
        q->next = q->next->next;
        return dummy.next;
    }
};