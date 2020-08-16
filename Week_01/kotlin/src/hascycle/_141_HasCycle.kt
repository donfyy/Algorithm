package hascycle

fun hasCycle(head: ListNode?): Boolean {
    var tortoise = head
    var hare = head
    while (hare?.next != null) {
        hare = hare.next?.next
        tortoise = tortoise?.next
        if (hare == tortoise) {
            return true
        }
    }
    return false
}