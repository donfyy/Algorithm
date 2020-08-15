fun reverseList(head: ListNode?): ListNode? {
    var headNew: ListNode? = null
    var node = head
    while (node != null) {
        val curr = node
        node = node.next
        curr.next = headNew
        headNew = curr
    }
    return headNew
}

class _206_Recursive_ {
    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val tail = head.next
        val headNew = reverseList(tail)
        tail?.next = head
        head.next = null
        return headNew
    }
}