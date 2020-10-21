class _143_ {
    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    class Solution {
        fun reorderList(head: ListNode?): Unit {
            head ?: return
            // 1.找到中间节点
            fun midOf(h: ListNode?): ListNode? {
                var p = h
                var q = h
                while (p?.next != null && p?.next?.next != null) {
                    p = p?.next?.next
                    q = q?.next
                }
                return q
            }

            val m = midOf(head)

            // 2.反转后半段
            fun reverse(p: ListNode?): ListNode? {
                var h: ListNode? = null
                var q = p
                while (q != null) {
                    val t = q?.next
                    q?.next = h
                    h = q
                    q = t
                }
                return h
            }

            val r = reverse(m?.next)
            m?.next = null
            // 3.合并两段链表
            fun merge(p: ListNode?, q: ListNode?): Unit {
                var l = p
                var r = q
                while (r != null) {
                    val t = r?.next
                    r?.next = l?.next
                    l?.next = r
                    l = r?.next
                    r = t
                }
            }
            merge(head, r)
        }
    }
}