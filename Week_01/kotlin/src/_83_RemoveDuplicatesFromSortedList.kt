fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head == null || head.next == null) return head
    head.next = deleteDuplicates(head.next)
    return if (head.next!!.`val` == head.`val`) head.next else head
}

fun deleteDuplicates2(head: ListNode?): ListNode? {
    var curr = head
    while (curr != null) {
        while (curr.next?.`val` == curr.`val`) {
            curr.next = curr.next?.next
        }
        curr = curr.next
    }
    return head
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}