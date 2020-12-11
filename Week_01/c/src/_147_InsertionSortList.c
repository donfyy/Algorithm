struct ListNode
{
    int val;
    struct ListNode *next;
};
struct ListNode *insertionSortList(struct ListNode *head)
{
    if (!head)
        return head;
    struct ListNode dummy = {0, head}, *tail = head, *curr = head->next;
    while (curr)
    {
        if (tail->val <= curr->val)
        {
            tail = tail->next;
        }
        else
        {
            struct ListNode *p = &dummy;
            while (p->next->val <= curr->val)
            {
                p = p->next;
            }
            tail->next = curr->next;
            curr->next = p->next;
            p->next = curr;
        }
        curr = tail->next;
    }
    return dummy.next;
}