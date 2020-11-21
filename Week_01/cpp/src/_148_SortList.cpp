struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Iterator2
{
public:
    ListNode *sortList(ListNode *head)
    {
        // 自顶向下的递归空间复杂度一定不是O(1)
        // 而自底向上的循环空间复杂度可能是O(1)，因此这道题用的是循环的归并
        // 先求出链表的长度l
        // 然后将链表划分成长度为m的若干个子链表，两两归并相邻的子链表，直到 (m << 1) >= l
        if (!head)
            return head;
        int l = 0;
        auto p = head;
        while (p)
        {
            l++;
            p = p->next;
        }

        ListNode dummy(0, head);
        for (int m = 1; m < l; m <<= 1)
        {
            auto t = &dummy, h = dummy.next;
            while (h)
            {
                auto h1 = h;
                auto h2 = split(h1, m);
                h = split(h2, m);
                t = merge(h1, h2, t);
            }
        }
        return dummy.next;
    }
    // 将链表分割为2个链表，第一个链表包含n个节点，返回第二个链表的头部
    ListNode *split(ListNode *h, int n)
    {
        for (int i = 1; i < n && h; i++)
        {
            h = h->next;
        }
        if (!h)
            return nullptr;
        auto t = h->next;
        h->next = nullptr;
        return t;
    }
    ListNode *merge(ListNode *h1, ListNode *h2, ListNode *h)
    {
        ListNode dummy, *p = &dummy;
        while (h1 && h2)
        {
            if (h1->val < h2->val)
            {
                p->next = h1;
                h1 = h1->next;
            }
            else
            {
                p->next = h2;
                h2 = h2->next;
            }
            p = p->next;
        }
        p->next = h1 ? h1 : h2;
        h->next = dummy.next;
        while (p->next)
            p = p->next;
        return p;
    }
};
class Solution
{
public:
    ListNode *sortList(ListNode *head)
    {
        // 自顶向下的递归，空间复杂度一定是O(logn)
        // 自底向上的循环，则空间复杂度是O(1)
        // 首先计算链表的长度为n
        // 然后将链表拆分成子链表长度为m，让
        if (head == nullptr)
        {
            return head;
        }
        // 求出链表的长度
        int length = 0;
        ListNode *node = head;
        while (node != nullptr)
        {
            length++;
            node = node->next;
        }
        ListNode *dummy = new ListNode(0, head);
        // 将链表划分成若干个长度为subLength的子链表，subLength 的长度从1 -> subLength << 1 >= length
        for (int subLength = 1; subLength < length; subLength <<= 1)
        {
            ListNode *prev = dummy, *curr = dummy->next;
            while (curr != nullptr)
            {
                // 分别得到长度为subLength的两个子链表head1，head2然后合并这两个子链表
                ListNode *head1 = curr;
                // 当i是1时， curr指向第一个元素，当i是subLength时，curr指向第subLength个元素。
                // curr指向子链表的最后一个元素
                for (int i = 1; i < subLength && curr->next != nullptr; i++)
                {
                    curr = curr->next;
                }
                ListNode *head2 = curr->next;
                curr->next = nullptr;
                ListNode *next = nullptr;
                curr = head2;
                if (curr != nullptr)
                {
                    for (int i = 1; i < subLength && curr->next != nullptr; i++)
                    {
                        curr = curr->next;
                    }
                    // 临时记录第三个子链表的头节点
                    // 如果curr是NULL，则head2一定是NULL，如果curr不是null，但是curr->next是null，则没有更多的子链表了
                    next = curr->next;
                    curr->next = nullptr;
                }
                // 得到合并后的链表的头节点
                ListNode *head, *tail;
                merge(head1, head2, &head, &tail);
                // 将合并后的链表链接到已合并链表
                prev->next = head;
                prev = tail;
                // 记录第三个子链表的头节点，合并剩下的链表
                curr = next;
            }
        }
        return dummy->next;
    }

    void merge(ListNode *p, ListNode *q, ListNode **head, ListNode **tail)
    {
        ListNode dummy, *h = &dummy;
        while (p && q)
        {
            if (p->val < q->val)
            {
                h->next = p;
                p = p->next;
            }
            else
            {
                h->next = q;
                q = q->next;
            }
            h = h->next;
        }
        h->next = p ? p : q;
        while (h->next)
        {
            h = h->next;
        }
        *tail = h;
        *head = dummy.next;
    }
};
