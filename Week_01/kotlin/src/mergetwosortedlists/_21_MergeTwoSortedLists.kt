package mergetwosortedlists

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var p = l1
    var q = l2
    if (p == null || q != null && p.`val` > q.`val`) {
        p = q?.also { q = p }
    }
    if (p != null) {
        p.next = mergeTwoLists(p.next, q)
    }
    return p
}

class _21_Iterative_ {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val hair = ListNode(-1)
        var p = l1
        var q = l2
        var k = hair
        while (p != null && q != null) {
            if (p.`val` < q.`val`) {
                k.next = p
                p = p.next
            } else {
                k.next = q
                q = q.next
            }
            k = k.next!!
        }
        k.next = p ?: q
        return hair.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
