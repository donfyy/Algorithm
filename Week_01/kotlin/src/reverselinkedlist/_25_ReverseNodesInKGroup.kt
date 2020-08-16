package reverselinkedlist

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    val hair = ListNode(-1)
    hair.next = head
    var preTailK = hair
    var headK = head
    while (headK != null) {
        var tailK = headK
        for (i in 1 until k) {
            tailK = tailK?.next
            if (tailK == null) {
                return hair.next
            }
        }

        val (h, t) = reverse(headK, tailK!!)
        preTailK.next = h
        preTailK = t
        headK = t.next
    }
    return hair.next
}

fun reverse(head: ListNode, tail: ListNode): Pair<ListNode, ListNode> {
    var headNew = tail.next
    var curr: ListNode? = head
    while (headNew != tail) {
        val node = curr
        curr = curr?.next
        node?.next = headNew
        headNew = node
    }
    return Pair(tail, head)
}