package reverselinkedlist

fun swapPairs(head: ListNode?): ListNode? {
    val hair = ListNode(-1)
    hair.next = head
    var preTail = hair
    var curr = head
    while (curr?.next != null) {
        val first = curr
        val second = curr.next
        curr = second?.next
        preTail.next = second
        second?.next = first
        first.next = curr
        preTail = first
    }
    return hair.next
}

class _24_Recursive_ {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val first = head
        val second = head.next!!
        first.next = swapPairs(second.next)
        second.next = first
        return second
    }
}