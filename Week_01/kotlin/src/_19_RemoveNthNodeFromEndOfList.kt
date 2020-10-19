class _19_RemoveNthNodeFromEndOfList_ {
    class Solution {
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            var p = head
            repeat(n) { p = p?.next }
            if (p == null) return head?.next
            var q = head
            while (p?.next != null) {
                p = p?.next
                q = q?.next
            }
            q?.next = q?.next?.next
            return head
        }
    }
}