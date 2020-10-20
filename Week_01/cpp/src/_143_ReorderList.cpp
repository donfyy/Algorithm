#include <iostream>
using namespace std;
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
    // 没有想到先逆序，然后再合并。。
    void reorderList(ListNode *head)
    {
        if (!head)
            return;
        // 找到中间节点
        auto p = midOf(head);
        // 将后半段链表反转
        auto q = reverse(p->next);
        p->next = NULL;
        // 合并两个链表
        merge(head, q);
    }
    void merge(ListNode *p, ListNode *q)
    {
        while (q)
        {
            auto t = p->next;
            p->next = q;
            q = q->next;
            p->next->next = t;
            p = t;
        }
    }
    ListNode *reverse(ListNode *p)
    {
        ListNode *head = NULL;
        while (p)
        {
            auto q = p->next;
            p->next = head;
            head = p;
            p = q;
        }
        return head;
    }
    // 节点数为奇数则返回中间节点，否则返回前半段最后一个节点
    ListNode *midOf(ListNode *p)
    {
        auto q = p;
        while (p->next && p->next->next)
        {
            p = p->next->next;
            q = q->next;
        }
        return q;
    }
};