package hascycle

fun detectCycle(head: ListNode?): ListNode? {
    var tortoise = head
    var hare = head
    while (hare?.next != null) {
        hare = hare.next?.next
        tortoise = tortoise?.next
        if (hare == tortoise) {
            break;
        }
    }
    if (hare?.next == null) {
        return null
    }
    var p = head
    var q = hare
    while (p != q) {
        p = p?.next
        q = q?.next
    }
    return p
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}