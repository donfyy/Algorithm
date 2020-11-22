class _148_SortList_ {
    class MergeBottomUp {
        fun sortList(head: ListNode?): ListNode? {
            // 自顶向下的递归一定不是常数空间复杂度，但是自底向上的循环也许可以做到
            // 自底向上的归并
            // 求出链表的长度l
            // 将链表划分成若干个长度为step的子链表，两两合并相邻的子链表
            // 更新step，step <<= 1; 直到step >= l
            // O(nlogn) O(1)
            head ?: return null
            var h = head
            var l = 0
            while (h != null) {
                h = h.next
                l++
            }
            val dummy = ListNode(0).apply { this.next = head }
            var m = 1
            while (m < l) {
                var t: ListNode? = dummy
                h = dummy.next
                while (h != null) {
                    val h1 = h
                    val h2 = split(h1, m)
                    h = split(h2, m)
                    t = merge(h1, h2, t)
                }
                m = m shl 1
            }
            return dummy.next
        }

        private fun split(n: ListNode?, l: Int): ListNode? {
            var h = n
            var i = 1
            while (i < l && h != null) {
                h = h.next
                i++
            }
            h ?: return null
            return h.next.also { h.next = null }
        }

        private fun merge(h1: ListNode?, h2: ListNode?, t: ListNode?): ListNode? {
            t ?: return null
            var h = t
            var p = h1
            var q = h2
            while (p != null && q != null) {
                if (p.`val` < q.`val`) {
                    h?.next = p
                    p = p.next
                } else {
                    h?.next = q
                    q = q.next
                }
                h = h?.next
            }
            h?.next = p ?: q
            while (h?.next != null) {
                h = h.next
            }
            return h
        }
    }

    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    class MergeTopDown {
        fun sortList(h: ListNode?): ListNode? {
            h?.next ?: return h
            var p = h
            val dummy: ListNode? = ListNode(0).apply { this.next = h }
            var q = dummy
            while (p?.next != null) {
                p = p.next?.next
                q = q?.next
            }
            q = q?.next?.also { q?.next = null }
            p = sortList(h)
            q = sortList(q)
            var t = dummy
            while (p != null && q != null) {
                if (p.`val` < q.`val`) {
                    t?.next = p.also { p = p?.next }
                } else {
                    t?.next = q.also { q = q?.next }
                }
                t = t?.next
            }
            t?.next = p ?: q
            return dummy?.next
        }
    }
}