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
    ListNode *swapPairs(ListNode *head)
    {
        ListNode dummy(0, head);
        head = &dummy;
        // 1 -> 2 -> 3 -> 4
        while (head->next && head->next->next)
        {
            auto n = head->next->next;
            head->next->next = n->next;
            n->next = head->next;
            head->next = n;
            head = head->next->next;
        }
        return dummy.next;
    }
};