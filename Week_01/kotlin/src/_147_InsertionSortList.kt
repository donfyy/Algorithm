class _147_InsertionSortList_ {
    class Solution {
        fun insertionSortList(head: ListNode?): ListNode? {
            // 设链表的元素个数为n，考虑扫描到第i个元素的时候链表的顺序为l1,l2...li-1lili+1...ln-1
            // 假设l1,l2...li-1是有序的，由于链表是单向的，我们需要从前向后扫描[1, i - 1]找到待插入位置的前一个节点
            // 因此为了方便我们添加一个dummy节点
            head?.next?:return head
            val dummy = ListNode(0).apply { this.next = head }
            var tail = head
            var curr = head.next
            while (curr != null) {
                if (tail!!.`val` <= curr.`val`) {
                    tail = curr
                } else {
                    var pre: ListNode? = dummy
                    while (pre!!.next!!.`val` < curr.`val`) {
                        pre = pre.next
                    }
                    tail.next = curr.next
                    curr.next = pre.next
                    pre.next = curr
                }
                curr = tail.next
            }
            return dummy.next
        }
    }
}