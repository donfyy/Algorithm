class _234_PalindromeLinkedList_ {
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
        fun isPalindrome(head: ListNode?): Boolean {
            if (head?.next == null) return true
            // 找到中间节点
            var p = head
            var q = head
            while (p?.next != null && p?.next?.next != null) {
                p = p?.next?.next
                q = q?.next
            }
            // 反转链表
            p = null
            q = q?.next
            while (q != null) {
                val t = q?.next
                q?.next = p
                p = q
                q = t
            }
            // 比较链表
            q = head
            while (p != null) {
                if (q?.`val` != p?.`val`) return false
                q = q?.next
                p = p?.next
            }
            return true
        }
    }
}