#include <stack>
using namespace std;
struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
class Solution
{
public:
    // 从低位加到高位
    // todo: 从高位加到低位
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        stack<int> s1, s2;
        ListNode dummy(0), *p;
        while (l1)
        {
            s1.push(l1->val);
            l1 = l1->next;
        }
        while (l2)
        {
            s2.push(l2->val);
            l2 = l2->next;
        }
        int carry = 0;
        while (!s1.empty() || !s2.empty() || carry)
        {
            if (!s1.empty())
            {
                carry += s1.top();
                s1.pop();
            }
            if (!s2.empty())
            {
                carry += s2.top();
                s2.pop();
            }
            p = new ListNode(carry % 10);
            p->next = dummy.next;
            dummy.next = p;
            carry /= 10;
        }
        return dummy.next;
    }
};