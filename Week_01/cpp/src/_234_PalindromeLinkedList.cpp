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
    bool isPalindrome(ListNode *head)
    {
        if (not head or not head->next)
            return true;
        // 找到中间节点
        auto p = head, q = head;
        while (p->next && p->next->next)
        {
            p = p->next->next;
            q = q->next;
        }
        // 反转后半段链表
        ListNode *h = NULL;
        p = q->next;
        while (p)
        {
            auto t = p->next;
            p->next = h;
            h = p;
            p = t;
        }
        // 比较两个链表是否相同
        p = head;
        while (h)
        {
            if (h->val != p->val)
            {
                return false;
            }
            h = h->next;
            p = p->next;
        }
        return true;
    }
};