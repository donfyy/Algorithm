#include <vector>
using namespace std;
struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
class UsingTwoPointer1
{
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB)
    {
        int m = getSize(headA), n = getSize(headB);
        int k = m - n;
        if (k < 0)
        {
            swap(headA, headB);
            k = -k;
        }
        ListNode *p1 = headA, *p2 = headB;
        while (k--)
        {
            p1 = p1->next;
        }
        while (p1 && p2)
        {
            if (p1 == p2)
                return p1;
            p1 = p1->next;
            p2 = p2->next;
        }
        return NULL;
    }
    int getSize(ListNode *node)
    {
        int cnt = 0;
        while (node)
        {
            node = node->next;
            cnt++;
        }
        return cnt;
    }
};
class UsingTwoPointer2
{
public:
    // 将a链表拼在b链表后，再将b链表拼在a链表后，两个新链表的长度就一致了
    // O(m + n) 非常妙，也非常简洁
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB)
    {
        auto p1 = headA, p2 = headB;
        while (p1 != p2)
        {
            p1 = p1 ? p1->next : headB;
            p2 = p2 ? p2->next : headA;
        }
        return p1;
    }
};